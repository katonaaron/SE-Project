package com.fullcart.session.Webshop.UserSession.statechans.C.ioifaces;

import com.fullcart.session.Webshop.UserSession.ops.Err;
import com.fullcart.session.Webshop.UserSession.ops.Ok;

public interface Handle_C_U_Err_String__U_Ok_User<__Succ1 extends Succ_In_U_Err_String, __Succ2 extends Succ_In_U_Ok_User> extends Callback_U_Err_String<__Succ1>, Callback_U_Ok_User<__Succ2> {

	void receive(__Succ1 schan, Err op, org.scribble.runtime.util.Buf<java.lang.String> arg1) throws org.scribble.main.ScribRuntimeException, java.io.IOException, ClassNotFoundException;

	void receive(__Succ2 schan, Ok op, org.scribble.runtime.util.Buf<com.fullcart.dto.UserDTO> arg1) throws org.scribble.main.ScribRuntimeException, java.io.IOException, ClassNotFoundException;
}
