package com.fullcart.session.Webshop.UserSession.statechans.U.ioifaces;

import com.fullcart.session.Webshop.UserSession.ops.Delete;
import com.fullcart.session.Webshop.UserSession.roles.C;

public interface In_C_Delete_Long<__Succ extends Succ_In_C_Delete_Long> {

	__Succ receive(C role, Delete op, org.scribble.runtime.util.Buf<? super java.lang.Long> arg1) throws org.scribble.main.ScribRuntimeException, java.io.IOException, ClassNotFoundException;
}
