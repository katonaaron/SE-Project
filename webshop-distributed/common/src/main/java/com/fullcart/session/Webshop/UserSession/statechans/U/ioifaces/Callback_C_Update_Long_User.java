package com.fullcart.session.Webshop.UserSession.statechans.U.ioifaces;

import com.fullcart.session.Webshop.UserSession.ops.Update;

public interface Callback_C_Update_Long_User<__Succ extends Succ_In_C_Update_Long_User> {

	void receive(__Succ schan, Update op, org.scribble.runtime.util.Buf<java.lang.Long> arg1, org.scribble.runtime.util.Buf<com.fullcart.dto.UserDTO> arg2) throws org.scribble.main.ScribRuntimeException, java.io.IOException, ClassNotFoundException;
}
