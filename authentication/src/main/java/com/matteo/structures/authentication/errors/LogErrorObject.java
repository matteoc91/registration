package com.matteo.structures.authentication.errors;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class LogErrorObject extends ErrorObject {
	
	private final Log log = LogFactory.getLog(this.getClass());
	
	private Class<?> objectClass;
	private String methodName;
	private String message;
	
	public LogErrorObject(ErrorsRegistry errorsRegistry) {
		super(errorsRegistry);
	}
	
	@Override
	public void manageError() {
		log.error("[ERROR] - Occured in class " + this.objectClass + " method " + this.methodName);
		log.error("[ERROR] - " + this.message);
	}

	public Class<?> getObjectClass() {
		return objectClass;
	}

	public void setObjectClass(Class<?> objectClass) {
		this.objectClass = objectClass;
	}

	public String getMethodName() {
		return methodName;
	}

	public void setMethodName(String methodName) {
		this.methodName = methodName;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
