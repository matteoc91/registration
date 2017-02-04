package com.matteo.structures.authentication.registration;

import java.util.HashMap;
import java.util.Map;

import com.matteo.structures.authentication.services.ValidatorSerivce;
import com.matteo.structures.authentication.utils.ApplicationContextUtils;

public class RegistrationSecondStepManager extends RegistrationStepManager {

	private ValidatorSerivce validatorSerivce;
	
	private String password;
	private String confirmPassword;
	
	public RegistrationSecondStepManager(RegistrationManager registrationManager) {
		super(registrationManager);
		this.validatorSerivce = 
				ApplicationContextUtils.getApplicationContext().getBean(ValidatorSerivce.class);
	}
	
	@Override
	protected boolean performStepInner() {
		boolean done = false;
		if (this.validateParameters()) {
			/**
			 * TODO: do something here
			 */
			done = true;
		}
		return done;
	}
	
	@Override
	public Map<String, Object> buildParameters() {
		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("password", this.password);
		parameters.put("confirmPassword", this.confirmPassword);
		return parameters;
	}
	
	/**
	 * Validate parameters
	 * 
	 * @return true if parameters are valid, false instead
	 */
	private boolean validateParameters() {
		return this.validatorSerivce.checkNotEmpty(this.password, "password", "Password required!") && 
				this.validatorSerivce.validatePassword(this.password) && 
				this.validatorSerivce.checkEquals(this.password, this.confirmPassword, false, "password", "Password mismatch!");
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}

}
