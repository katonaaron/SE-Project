package com.fullcart.session.Webshop.BuyingSession.statechans.B.ioifaces;

import com.fullcart.session.Webshop.BuyingSession.ops.NotFound;
import com.fullcart.session.Webshop.BuyingSession.ops.Ok;

public interface Handle_B_U_NotFound_Long__U_Ok_User<__Succ1 extends Succ_In_U_NotFound_Long, __Succ2 extends Succ_In_U_Ok_User> extends Callback_U_NotFound_Long<__Succ1>, Callback_U_Ok_User<__Succ2> {

	void receive(__Succ1 schan, NotFound op, org.scribble.runtime.util.Buf<java.lang.Long> arg1) throws org.scribble.main.ScribRuntimeException, java.io.IOException, ClassNotFoundException;

	void receive(__Succ2 schan, Ok op, org.scribble.runtime.util.Buf<com.fullcart.dto.UserDTO> arg1) throws org.scribble.main.ScribRuntimeException, java.io.IOException, ClassNotFoundException;
}
