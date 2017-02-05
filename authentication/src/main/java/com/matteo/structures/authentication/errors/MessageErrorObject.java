package com.matteo.structures.authentication.errors;

import com.matteo.structures.authentication.utils.ApplicationContextUtils;
import com.matteo.structures.authentication.utils.MessagesRegistry;

public class MessageErrorObject extends ErrorAbstractObject {
	
	private String key;
	private String message;
	private MessagesRegistry messagesRegistry;

	public MessageErrorObject(ErrorsRegistry errorsRegistry) {
		super(errorsRegistry);
		this.messagesRegistry = 
				ApplicationContextUtils.getApplicationContext().getBean(MessagesRegistry.class);
	}
	
	public void manageError() {
		if (this.messagesRegistry != null) {
			this.messagesRegistry.addMessage(this.key, this.message);
		}
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
