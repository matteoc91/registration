package com.matteo.structures.authentication.utils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.ui.ModelMap;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.matteo.structures.authentication.errors.ErrorsFactory;

public class MessagesHandlerInterceptor extends HandlerInterceptorAdapter {

	private MessagesRegistry messagesRegistry;
	private ErrorsFactory errorsFactory;
	
	public MessagesHandlerInterceptor() {
		this.messagesRegistry = 
				ApplicationContextUtils.getApplicationContext().getBean(MessagesRegistry.class);
		this.errorsFactory = 
				ApplicationContextUtils.getApplicationContext().getBean(ErrorsFactory.class);
	}
	
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		this.errorsFactory.manageErrors();
		ModelMap modelMap = modelAndView.getModelMap();
		Map<String, List<String>> messages = new HashMap<String, List<String>>();
		messages.putAll(this.messagesRegistry.getMessages());
		modelMap.addAttribute("messages", messages);
		this.messagesRegistry.clearMessages();
	}
	
}
