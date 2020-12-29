package com.fullcart.webshop.controller

import com.fullcart.dto.ProductDTO
import com.fullcart.webshop.model.Product
import com.fullcart.webshop.model.assembler.ProductModelAssembler
import com.fullcart.webshop.repository.ProductRepository
import com.fullcart.webshop.service.ProductService
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.{linkTo, methodOn}
import org.springframework.hateoas.{CollectionModel, EntityModel, IanaLinkRelations, Links}
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation._

import javax.validation.Valid

@RestController
class ProductController(private val repository: ProductRepository, private val productService: ProductService, private val assembler: ProductModelAssembler) {

  @GetMapping(Array("/products"))
  def findAll(): ResponseEntity[CollectionModel[EntityModel[Product]]] =
    ResponseEntity.ok(assembler.toCollectionModel(repository.findAll()))

  @PostMapping(Array("/products"))
  def newProduct(@Valid @RequestBody product: ProductDTO): ResponseEntity[_ <: ProductDTO] = {
    productService.create(product) match {
      case Some(product) =>
        ResponseEntity
          .ok(product)
      case _ => ResponseEntity.unprocessableEntity().build()
    }

    //    val entityModel = assembler.toModel(repository.save(product))
    //
    //    ResponseEntity
    //      .created(entityModel.getRequiredLink(IanaLinkRelations.SELF).toUri)
    //      .body(entityModel)

  }

  @GetMapping(Array("/products/{id}"))
  def one(@PathVariable id: Long): ResponseEntity[_ <: ProductDTO] = {
    productService.getOne(id) match {
      case Some(product) => ResponseEntity.ok(product)
      case _ => ResponseEntity.notFound().build()
    }
  }

  @PutMapping(Array("/products/{id}"))
  def replaceProduct(@Valid @RequestBody newProduct: Product, @PathVariable id: Long): ResponseEntity[EntityModel[Product]] = {
    val updatedProduct = repository.findById(id)
      .map { product =>
        product.price = newProduct.price
        product.name = newProduct.name
        product.description = newProduct.description
        repository.save(product)
      }
      .orElseGet { () =>
        newProduct.id = id
        repository.save(newProduct)

      }

    val entityModel = assembler.toModel(updatedProduct)
    ResponseEntity
      .created(entityModel.getRequiredLink(IanaLinkRelations.SELF).toUri)
      .body(entityModel)
  }

  @DeleteMapping(Array("/products/{id}"))
  def deleteProduct(@PathVariable id: Long): ResponseEntity[Nothing] = {
    repository.deleteById(id)
    ResponseEntity.noContent().build()
  }

  @GetMapping(Array("/orders/{id}/products"))
  def findProducts(@PathVariable id: Long): ResponseEntity[CollectionModel[EntityModel[Product]]] = {
    val collectionModel = assembler.toCollectionModel(repository.findByOrdersId(id))

    val newLinks = collectionModel.getLinks.merge(Links.MergeMode.REPLACE_BY_REL,
      linkTo(methodOn(classOf[ProductController]).findProducts(id)).withSelfRel()
    )

    ResponseEntity.ok(CollectionModel.of(collectionModel.getContent, newLinks))
  }

}
