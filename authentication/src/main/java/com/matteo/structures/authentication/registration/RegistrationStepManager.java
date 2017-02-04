package com.matteo.structures.authentication.registration;

import java.util.Map;

public abstract class RegistrationStepManager {

	private RegistrationManager registrationManager;
	
	public RegistrationStepManager(RegistrationManager registrationManager) {
		this.setRegistrationManager(registrationManager);
		registrationManager.addStep(this);
	}
	
	/**
	 * Perform registration step
	 * 
	 * @return true if operation succeeded, false instead
	 */
	public boolean performStep() {
		Map<String, Object> parameters = this.buildParameters();
		this.registrationManager.addParameters(parameters);
		return this.performStepInner();
		
	}
	
	/**
	 * Perform registration step inner
	 * Do not call this method outside of this class
	 * 
	 * @return true if operation succeeded, false instead
	 */
	protected abstract boolean performStepInner();
	
	/**
	 * Build parameters
	 */
	public abstract Map<String, Object> buildParameters();

	public RegistrationManager getRegistrationManager() {
		return registrationManager;
	}

	public void setRegistrationManager(RegistrationManager registrationManager) {
		this.registrationManager = registrationManager;
	}
	
}
