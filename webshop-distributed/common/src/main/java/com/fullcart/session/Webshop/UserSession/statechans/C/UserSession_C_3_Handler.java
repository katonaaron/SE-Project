package com.fullcart.session.Webshop.UserSession.statechans.C;

import com.fullcart.session.Webshop.UserSession.ops.NotFound;
import com.fullcart.session.Webshop.UserSession.ops.Ok;
import com.fullcart.session.Webshop.UserSession.statechans.C.ioifaces.Handle_C_U_NotFound__U_Ok_User;

public interface UserSession_C_3_Handler extends Handle_C_U_NotFound__U_Ok_User<UserSession_C_1, UserSession_C_1> {

	@Override
    void receive(UserSession_C_1 schan, Ok op, org.scribble.runtime.util.Buf<com.fullcart.dto.UserDTO> arg1) throws org.scribble.main.ScribRuntimeException, java.io.IOException, ClassNotFoundException;

	@Override
    void receive(UserSession_C_1 schan, NotFound op) throws org.scribble.main.ScribRuntimeException, java.io.IOException, ClassNotFoundException;
}
