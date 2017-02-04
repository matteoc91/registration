package com.matteo.structures.authentication.errors;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

@Component
@Scope(value = "session", proxyMode = ScopedProxyMode.TARGET_CLASS)
public class ErrorsFactory {

	private ErrorsRegistry errorsRegistry;
	
	public ErrorsFactory() {
		this.errorsRegistry = new DefaultErrorsRegistry();
	}
	
	/**
	 * Manage errors
	 */
	public void manageErrors() {
		this.errorsRegistry.manageErrors();
	}

	public ErrorsRegistry getErrorsRegistry() {
		return this.errorsRegistry;
	}
	
}
