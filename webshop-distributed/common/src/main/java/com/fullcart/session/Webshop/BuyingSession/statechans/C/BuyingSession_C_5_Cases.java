package com.fullcart.session.Webshop.BuyingSession.statechans.C;

import com.fullcart.session.Webshop.BuyingSession.BuyingSession;
import com.fullcart.session.Webshop.BuyingSession.ops.NotAllowed;
import com.fullcart.session.Webshop.BuyingSession.ops.NotFound;
import com.fullcart.session.Webshop.BuyingSession.ops.Ok;
import com.fullcart.session.Webshop.BuyingSession.roles.B;
import com.fullcart.session.Webshop.BuyingSession.roles.C;
import com.fullcart.session.Webshop.BuyingSession.statechans.C.ioifaces.Branch_C_B_NotAllowed__B_NotFound__B_Ok_Order;
import com.fullcart.session.Webshop.BuyingSession.statechans.C.ioifaces.Case_C_B_NotAllowed__B_NotFound__B_Ok_Order;

public final class BuyingSession_C_5_Cases extends org.scribble.runtime.statechans.CaseSocket<BuyingSession, C> implements Case_C_B_NotAllowed__B_NotFound__B_Ok_Order<BuyingSession_C_1, BuyingSession_C_1, BuyingSession_C_1> {
	public static final BuyingSession_C_5_Cases cast = null;
	public final BuyingSession_C_5.Branch_C_B_NotAllowed__B_NotFound__B_Ok_Order_Enum op;
	private final org.scribble.runtime.message.ScribMessage m;

	protected BuyingSession_C_5_Cases(org.scribble.runtime.session.SessionEndpoint<BuyingSession, C> se, boolean dummy, BuyingSession_C_5.Branch_C_B_NotAllowed__B_NotFound__B_Ok_Order_Enum op, org.scribble.runtime.message.ScribMessage m) {
		super(se);
		this.op = op;
		this.m = m;
	}

	public BuyingSession_C_1 receive(B role, Ok op, org.scribble.runtime.util.Buf<? super com.fullcart.dto.OrderDTO> arg1) throws org.scribble.main.ScribRuntimeException, java.io.IOException, ClassNotFoundException {
		super.use();
		if (!this.m.op.equals(BuyingSession.Ok)) {
			throw new org.scribble.main.ScribRuntimeException("Wrong branch, received: " + this.m.op);
		}
		arg1.val = (com.fullcart.dto.OrderDTO) m.payload[0];
		return new BuyingSession_C_1(this.se, true);
	}

	public BuyingSession_C_1 receive(Ok op, org.scribble.runtime.util.Buf<? super com.fullcart.dto.OrderDTO> arg1) throws org.scribble.main.ScribRuntimeException, java.io.IOException, ClassNotFoundException {
		return receive(BuyingSession.B, op, arg1);
	}

	@SuppressWarnings("unchecked")
	public BuyingSession_C_1 receive(Ok op) throws org.scribble.main.ScribRuntimeException, java.io.IOException, ClassNotFoundException {
		return receive(op, (org.scribble.runtime.util.Buf<com.fullcart.dto.OrderDTO>) this.se.gc);
	}

	public BuyingSession_C_1 receive(B role, NotFound op) throws org.scribble.main.ScribRuntimeException, java.io.IOException, ClassNotFoundException {
		super.use();
		if (!this.m.op.equals(BuyingSession.NotFound)) {
			throw new org.scribble.main.ScribRuntimeException("Wrong branch, received: " + this.m.op);
		}
		return new BuyingSession_C_1(this.se, true);
	}

	public BuyingSession_C_1 receive(NotFound op) throws org.scribble.main.ScribRuntimeException, java.io.IOException, ClassNotFoundException {
		return receive(BuyingSession.B, op);
	}

	public BuyingSession_C_1 receive(B role, NotAllowed op) throws org.scribble.main.ScribRuntimeException, java.io.IOException, ClassNotFoundException {
		super.use();
		if (!this.m.op.equals(BuyingSession.NotAllowed)) {
			throw new org.scribble.main.ScribRuntimeException("Wrong branch, received: " + this.m.op);
		}
		return new BuyingSession_C_1(this.se, true);
	}

	public BuyingSession_C_1 receive(NotAllowed op) throws org.scribble.main.ScribRuntimeException, java.io.IOException, ClassNotFoundException {
		return receive(BuyingSession.B, op);
	}

	@Override
	public Branch_C_B_NotAllowed__B_NotFound__B_Ok_Order.Branch_C_B_NotAllowed__B_NotFound__B_Ok_Order_Enum getOp() {
		return this.op;
	}
}
