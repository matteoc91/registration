package com.matteo.structures.authentication.errors;

public abstract class ErrorObject {
	
	public ErrorObject(ErrorsRegistry errorsRegistry) {
		errorsRegistry.addError(this);
	}
	

	/**
	 * Manage error
	 */
	public abstract void manageError();
	
}
