package com.matteo.structures.authentication.services;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.matteo.structures.authentication.errors.ErrorsFactory;
import com.matteo.structures.authentication.errors.ErrorsRegistry;
import com.matteo.structures.authentication.errors.MessageErrorObject;

@Service
public class ValidatorSerivce {
	
	@Autowired
	private ErrorsFactory errorsFactory;

	private static final String EMAIL_PATTERN = 
			"^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
	
	private static final int PASSWORD_LENGTH = 8;
	
	/**
	 * Check if value is not empty
	 * 
	 * @param value
	 * @param key
	 * @return true if value is not empty, false instead
	 */
	public boolean checkNotEmpty(String value, String key) {
		return this.checkNotEmpty(value, key, "Field empty!");
	}
	
	/**
	 * Check if value is not empty
	 * 
	 * @param value
	 * @param key
	 * @param message
	 * @return true if value is not empty, false instead
	 */
	public boolean checkNotEmpty(String value, String key, String message) {
		boolean notEmpty = false;
		if (StringUtils.isBlank(value)) {
			ErrorsRegistry errorsRegistry = this.errorsFactory.getErrorsRegistry();
			MessageErrorObject errorObject = new MessageErrorObject(errorsRegistry);
			errorObject.setKey(key);
			errorObject.setMessage(message);
		} else {
			notEmpty = true;
		}
		return notEmpty;
	}
	
	/**
	 * Check if fields are equals
	 * 
	 * @param arg0
	 * @param arg1
	 * @param ignoreCase
	 * @param key
	 * @return true if fields are equals, false instead
	 */
	public boolean checkEquals(String arg0, String arg1, boolean ignoreCase, String key) {
		return this.checkEquals(arg0, arg1, ignoreCase, key, "Fields not equals!");
	}
	
	/**
	 * Check if fields are equals
	 * 
	 * @param arg0
	 * @param arg1
	 * @param ignoreCase
	 * @param key
	 * @param message
	 * @return false instead
	 */
	public boolean checkEquals(String arg0, String arg1, boolean ignoreCase, String key, String message) {
		boolean equals = false;
		if ( (ignoreCase && !StringUtils.equalsIgnoreCase(arg0, arg1)) || 
				(!ignoreCase && !StringUtils.equals(arg0, arg1))) {
			ErrorsRegistry errorsRegistry = this.errorsFactory.getErrorsRegistry();
			MessageErrorObject errorObject = new MessageErrorObject(errorsRegistry);
			errorObject.setKey(key);
			errorObject.setMessage(message);
		} else {
			equals = true;
		}
		return equals;
	}
	
	/**
	 * Validate email
	 * 
	 * @param email
	 * @return true if email is valid, false instead
	 */
	public boolean validateEmail(String email) {
		return this.validateEmail(email, "email");
	}
	
	/**
	 * Validate email
	 * 
	 * @param email
	 * @param key
	 * @return true if email is valid, false instead
	 */
	public boolean validateEmail(String email, String key) {
		return this.validateEmail(email, key, "Email not valid!");
	}
	
	/**
	 * Validate email
	 * 
	 * @param email
	 * @param key
	 * @param message
	 * @return true if email is valid, false instead
	 */
	public boolean validateEmail(String email, String key, String message) {
		Pattern pattern = Pattern.compile(EMAIL_PATTERN);
		Matcher matcher = pattern.matcher(email);
		boolean valid = matcher.matches();
		if (!valid) {
			ErrorsRegistry errorsRegistry = this.errorsFactory.getErrorsRegistry();
			MessageErrorObject errorObject = new MessageErrorObject(errorsRegistry);
			errorObject.setKey(key);
			errorObject.setMessage(message);
		}
		return valid;
	}
	
	/**
	 * Validate password
	 * 
	 * @param password
	 * @return true if password is valid, false instead
	 */
	public boolean validatePassword(String password) {
		return this.validatePassword(password, "password");
	}
	
	/**
	 * Validate password
	 * 
	 * @param password
	 * @param key
	 * @return true if password is valid, false instead
	 */
	public boolean validatePassword(String password, String key) {
		return this.validatePassword(password, key, "Password not valid!");
	}
	
	/**
	 * Validate password
	 * 
	 * @param password
	 * @param key
	 * @param message
	 * @return true if password is valid, false instead
	 */
	public boolean validatePassword(String password, String key, String message) {
		boolean valid = false;
		if (StringUtils.length(password) < PASSWORD_LENGTH) {
			ErrorsRegistry errorsRegistry = this.errorsFactory.getErrorsRegistry();
			MessageErrorObject errorObject = new MessageErrorObject(errorsRegistry);
			errorObject.setKey(key);
			errorObject.setMessage(message);
		} else {
			valid = true;
		}
		return valid;
	}

	public ErrorsFactory getErrorsFactory() {
		return errorsFactory;
	}

	public void setErrorsFactory(ErrorsFactory errorsFactory) {
		this.errorsFactory = errorsFactory;
	}
	
	
	
}
