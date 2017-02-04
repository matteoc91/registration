package com.matteo.structures.authentication.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.matteo.structures.authentication.costants.IWebSiteCostants;
import com.matteo.structures.authentication.errors.ErrorsFactory;
import com.matteo.structures.authentication.registration.RegistrationFactory;

@Controller
public class RegistrationController extends CommonAbstractController {

	@Autowired
	private RegistrationFactory registrationFactory;
	
	@Autowired
	private ErrorsFactory errorsFactory;
	
	@RequestMapping(value = "registration-step-1", method = RequestMethod.POST)
	public String doFirstStep(ModelMap model, 
			@RequestParam(name = "email", required = false) String email, 
			@RequestParam(name = "confirm-email", required = false) String confirmEmail) {
		
		String pageToRedirect = IWebSiteCostants.REGISTRATION_FIRST_STEP;
		
		// Build registration manager
		this.registrationFactory.buildRegistrationManager();
		
		// Set registration first step manager
		this.registrationFactory.buildFirsStep(email, confirmEmail);
		
		// Perform registration
		if (this.registrationFactory.execute()) {
			pageToRedirect = "redirect:".concat(IWebSiteCostants.REGISTRATION_SECOND_STEP);
		}
		
		return pageToRedirect;
	}
	
	@RequestMapping(value = "registration-step-2", method = RequestMethod.POST)
	public String doSecondStep(ModelMap model, 
			@RequestParam(name = "password", required = false) String password, 
			@RequestParam(name = "confirm-password", required = false) String confirmPassword) {
		
		String pageToRedirect = IWebSiteCostants.REGISTRATION_SECOND_STEP;
		
		// Set registration second step manager
		this.registrationFactory.buildSecondStep(password, confirmPassword);
		
		// Perform registration
		if (this.registrationFactory.execute()) {
			pageToRedirect = "redirect:".concat(IWebSiteCostants.REGISTRATION_SUCCESS);
		}
		
		return pageToRedirect;
	}

	public RegistrationFactory getRegistrationFactory() {
		return registrationFactory;
	}

	public void setRegistrationFactory(RegistrationFactory registrationFactory) {
		this.registrationFactory = registrationFactory;
	}

	public ErrorsFactory getErrorsFactory() {
		return errorsFactory;
	}

	public void setErrorsFactory(ErrorsFactory errorsFactory) {
		this.errorsFactory = errorsFactory;
	}
	
}
