package com.jdc.online.balances.utils.listener;

import org.springframework.context.event.EventListener;
import org.springframework.security.authentication.event.AbstractAuthenticationFailureEvent;
import org.springframework.security.authentication.event.AuthenticationSuccessEvent;
import org.springframework.security.authentication.event.LogoutSuccessEvent;
import org.springframework.stereotype.Component;

@Component
public class AuthenticationEventListener {
	
	@EventListener
	public void handle(AuthenticationSuccessEvent event) {
		
	}
	
	@EventListener
	public void handle(AbstractAuthenticationFailureEvent event) {
		
	}
	
	@EventListener
	public void handle(LogoutSuccessEvent event) {
		
	}

}
