package com.fullcart.session.Webshop.UserSession.statechans.C;

import java.io.IOException;
import java.util.concurrent.CompletableFuture;

public class UserSession_C_2_Future extends org.scribble.runtime.util.ScribFuture {
	public java.util.List pay1;

	protected UserSession_C_2_Future(CompletableFuture<org.scribble.runtime.message.ScribMessage> fut) {
		super(fut);
	}

	public UserSession_C_2_Future sync() throws IOException {
		org.scribble.runtime.message.ScribMessage m = super.get();
		this.pay1 = (java.util.List) m.payload[0];
		return this;
	}
}