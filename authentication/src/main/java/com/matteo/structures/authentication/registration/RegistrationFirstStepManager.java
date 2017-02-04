package com.matteo.structures.authentication.registration;

import java.util.HashMap;
import java.util.Map;

import com.matteo.structures.authentication.services.ValidatorSerivce;
import com.matteo.structures.authentication.utils.ApplicationContextUtils;

public class RegistrationFirstStepManager extends RegistrationStepManager {
	
	private ValidatorSerivce validatorSerivce;
	
	private String email;
	private String confirmEmail;

	public RegistrationFirstStepManager(RegistrationManager registrationManager) {
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
		parameters.put("email", this.email);
		parameters.put("confirmEmail", this.confirmEmail);
		return parameters;
	}
	
	/**
	 * Validate parameters
	 * 
	 * @return true if parameters are valid, false instead
	 */
	private boolean validateParameters() {
		return this.validatorSerivce.checkNotEmpty(this.email, "email", "Email required!") && 
				this.validatorSerivce.validateEmail(this.email) && 
				this.validatorSerivce.checkEquals(this.email, this.confirmEmail, false, "email", "Email mismatch!");
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getConfirmEmail() {
		return confirmEmail;
	}

	public void setConfirmEmail(String confirmEmail) {
		this.confirmEmail = confirmEmail;
	}

}
