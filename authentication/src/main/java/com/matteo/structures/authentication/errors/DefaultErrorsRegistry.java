package com.matteo.structures.authentication.errors;

import java.util.LinkedList;
import java.util.List;

public class DefaultErrorsRegistry implements ErrorsRegistry {
	
	private List<ErrorObject> errors;
	
	public DefaultErrorsRegistry() {
		this.errors = new LinkedList<ErrorObject>();
	}

	public void addError(ErrorObject errorObject) {
		this.errors.add(errorObject);
	}

	public void manageErrors() {
		for (ErrorObject error : this.errors) {
			error.manageError();
		}
		this.errors.clear();
	}

}
