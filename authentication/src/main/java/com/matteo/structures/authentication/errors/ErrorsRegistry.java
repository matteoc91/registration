package com.matteo.structures.authentication.errors;

public interface ErrorsRegistry {

	/**
	 * Add error to registry
	 * 
	 * @param errorObject
	 */
	public void addError(ErrorObject errorObject);
	
	/**
	 * Manage errors
	 */
	public void manageErrors();
	
}
