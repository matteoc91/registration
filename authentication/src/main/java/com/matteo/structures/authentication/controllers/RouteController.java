package com.matteo.structures.authentication.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.matteo.structures.authentication.costants.IWebSiteCostants;

@Controller
public class RouteController extends CommonAbstractController {

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String index(ModelMap model) {
		return IWebSiteCostants.INDEX;
	}
	
	@RequestMapping(value = "registration", method = RequestMethod.GET)
	public String registration(ModelMap model) {
		return IWebSiteCostants.REGISTRATION;
	}
	
	@RequestMapping(value = "registration-step-1", method = RequestMethod.GET)
	public String registrationFirstStep(ModelMap model) {
		return IWebSiteCostants.REGISTRATION_FIRST_STEP;
	}
	
	@RequestMapping(value = "registration-step-2", method = RequestMethod.GET)
	public String registrationSecondStep(ModelMap model) {
		return IWebSiteCostants.REGISTRATION_SECOND_STEP;
	}
	
	@RequestMapping(value = "registration-success", method = RequestMethod.GET)
	public String registrationSuccess(ModelMap model) {
		return IWebSiteCostants.REGISTRATION_SUCCESS;
	}
	
}
