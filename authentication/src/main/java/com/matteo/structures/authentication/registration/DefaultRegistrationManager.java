package com.matteo.structures.authentication.registration;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import com.matteo.structures.authentication.errors.ErrorsRegistry;

public class DefaultRegistrationManager implements RegistrationManager {
	
	private List<RegistrationStepManager> stepsManagers;
	private ErrorsRegistry errorsRegistry;
	private Map<String, Object> parameters;
	
	public DefaultRegistrationManager() {
		this.stepsManagers = new LinkedList<RegistrationStepManager>();
		this.parameters = new HashMap<String, Object>();
	}

	public void addStep(RegistrationStepManager stepManager) {
		this.stepsManagers.add(stepManager);
	}

	public boolean performRegistration() {
		boolean done = false;
		if (!this.stepsManagers.isEmpty()) {
			int index = this.stepsManagers.size() - 1;
			done = this.stepsManagers.get(index).performStep();
		}
		return done;
	}

	public void setErrorsRegistry(ErrorsRegistry errorsRegistry) {
		this.errorsRegistry = errorsRegistry;
	}
	
	public ErrorsRegistry getErrorsRegistry() {
		return this.errorsRegistry;
	}

	public void addParameters(Map<String, Object> parameters) {
		if (parameters != null && !parameters.isEmpty()) {
			this.parameters.putAll(parameters);
		}
	}

	public Object getParameter(String key) {
		Object value = null;
		if (this.parameters.containsKey(key)) {
			value = this.parameters.get(key);
		}
		return value;
	}

}
