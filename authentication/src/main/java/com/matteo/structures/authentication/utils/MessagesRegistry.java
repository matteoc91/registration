package com.matteo.structures.authentication.utils;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

import com.matteo.structures.authentication.errors.ErrorsFactory;
import com.matteo.structures.authentication.errors.ErrorsRegistry;
import com.matteo.structures.authentication.errors.LogErrorObject;

@Component
@Scope(value = "session", proxyMode = ScopedProxyMode.TARGET_CLASS)
public class MessagesRegistry {
	
	@Autowired
	private ErrorsFactory errorsFactory;

	private Map<String, List<String>> messages;
	
	public MessagesRegistry() {
		this.messages = new HashMap<String, List<String>>();
	}
	
	/**
	 * Add message to map
	 * 
	 * @param key
	 * @param message
	 */
	public void addMessage(String key, String message) {
		if (StringUtils.isNotBlank(key)) {
			List<String> messages = new LinkedList<String>();
			if (this.messages.containsKey(key)) {
				messages = this.messages.get(key);
			}
			messages.add(message);
			this.messages.put(key, messages);
		} else {
			ErrorsRegistry errorsRegistry = this.errorsFactory.getErrorsRegistry();
			LogErrorObject errorObject = new LogErrorObject(errorsRegistry);
			errorObject.setObjectClass(this.getClass());
			errorObject.setMethodName("addMessage()");
			errorObject.setMessage("Key empty!");
		}
	}
	
	/**
	 * Get messages map
	 * 
	 * @return the messages map
	 */
	public Map<String, List<String>> getMessages() {
		return this.messages;
	}
	
	/**
	 * Clear messages
	 */
	public void clearMessages() {
		this.messages.clear();
	}

	public ErrorsFactory getErrorsFactory() {
		return errorsFactory;
	}

	public void setErrorsFactory(ErrorsFactory errorsFactory) {
		this.errorsFactory = errorsFactory;
	}
	
}
