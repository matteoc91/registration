package com.matteo.structures.authentication.registration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

import com.matteo.structures.authentication.errors.ErrorsFactory;
import com.matteo.structures.authentication.errors.LogErrorObject;

@Component
@Scope(value = "session", proxyMode = ScopedProxyMode.TARGET_CLASS)
public class RegistrationFactory {
	
	@Autowired
	private ErrorsFactory errorsFactory;

	private RegistrationManager registrationManager;
	
	/**
	 * Build registration manager
	 * 
	 * @return true
	 */
	public boolean buildRegistrationManager() {
		RegistrationManager registrationManager = new DefaultRegistrationManager();
		registrationManager.setErrorsRegistry(this.errorsFactory.getErrorsRegistry());
		this.registrationManager = registrationManager;
		return true;
	}
	
	/**
	 * Build first step
	 * 
	 * @param email
	 * @param confirmEmail
	 * @return true if operation succeeded, false instead
	 */
	public boolean buildFirsStep(String email, String confirmEmail) {
		boolean done = false;
		if (this.registrationManager != null) {
			RegistrationFirstStepManager registrationStepManager = new RegistrationFirstStepManager(this.registrationManager);
			registrationStepManager.setEmail(email);
			registrationStepManager.setConfirmEmail(confirmEmail);
			done = true;
		} else {
			LogErrorObject errorObject = 
					new LogErrorObject(this.errorsFactory.getErrorsRegistry());
			errorObject.setObjectClass(this.getClass());
			errorObject.setMethodName("buildFirsStep()");
			errorObject.setMessage("Registration manager not initialized");
		}
		return done;
	}
	
	/**
	 * Build second step
	 * 
	 * @param password
	 * @param confirmPassword
	 * @return true if operation succeeded, false instead
	 */
	public boolean buildSecondStep(String password, String confirmPassword) {
		boolean done = false;
		if (this.registrationManager != null) {
			RegistrationSecondStepManager registrationStepManager = new RegistrationSecondStepManager(this.registrationManager);
			registrationStepManager.setPassword(password);
			registrationStepManager.setConfirmPassword(confirmPassword);
			done = true;
		} else {
			LogErrorObject errorObject = 
					new LogErrorObject(this.errorsFactory.getErrorsRegistry());
			errorObject.setObjectClass(this.getClass());
			errorObject.setMethodName("buildSecondStep()");
			errorObject.setMessage("Registration manager not initialized");
		}
		return done;
	}
	
	/**
	 * Execute registration
	 * 
	 * @return true if operation succeeded, false instead
	 */
	public boolean execute() {
		boolean done = false;
		if (this.registrationManager != null) {
			done = this.registrationManager.performRegistration();
		} else {
			LogErrorObject errorObject = 
					new LogErrorObject(this.errorsFactory.getErrorsRegistry());
			errorObject.setObjectClass(this.getClass());
			errorObject.setMethodName("execute()");
			errorObject.setMessage("Registration manager not initialized");
		}
		return done;
	}

	public ErrorsFactory getErrorsFactory() {
		return errorsFactory;
	}

	public void setErrorsFactory(ErrorsFactory errorsFactory) {
		this.errorsFactory = errorsFactory;
	}
	
}
