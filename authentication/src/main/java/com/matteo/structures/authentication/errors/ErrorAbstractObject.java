package com.matteo.structures.authentication.errors;

public abstract class ErrorAbstractObject implements ErrorObject {
	
	public ErrorAbstractObject(ErrorsRegistry errorsRegistry) {
		errorsRegistry.addError(this);
	}
	
}
