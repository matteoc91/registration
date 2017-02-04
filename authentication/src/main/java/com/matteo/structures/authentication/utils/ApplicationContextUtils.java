package com.matteo.structures.authentication.utils;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

@Component
public class ApplicationContextUtils implements ApplicationContextAware {

	public void setApplicationContext(ApplicationContext applicationContext) 
			throws BeansException {
		AppContext.setApplicationContext(applicationContext);
	}
	
	public static ApplicationContext getApplicationContext() {
		return AppContext.getApplicationContext();
	}

}
