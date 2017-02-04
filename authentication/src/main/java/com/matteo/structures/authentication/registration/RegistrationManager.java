package com.matteo.structures.authentication.registration;

import java.util.Map;

import com.matteo.structures.authentication.errors.ErrorsRegistry;

public interface RegistrationManager {

	/**
	 * Add registration step manager to list
	 * 
	 * @param stepManager
	 */
	public void addStep(RegistrationStepManager stepManager);
	
	/**
	 * Perform registration
	 * 
	 * @return true if operation succeeded, false instead
	 */
	public boolean performRegistration();
	
	/**
	 * Set errors registry
	 * 
	 * @param errorsRegistry
	 */
	public void setErrorsRegistry(ErrorsRegistry errorsRegistry);
	
	/**
	 * Get errors registry
	 * 
	 * @return the errors registry
	 */
	public ErrorsRegistry getErrorsRegistry();
	
	/**
	 * Add parameters to map
	 * 
	 * @param parameters
	 */
	public void addParameters(Map<String, Object> parameters);
	
	/**
	 * Get parameter associated to the given key
	 * 
	 * @param key
	 * @return the value or null instead
	 */
	public Object getParameter(String key);
	
}
