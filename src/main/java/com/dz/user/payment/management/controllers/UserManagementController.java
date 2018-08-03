package com.dz.user.payment.management.controllers;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.dz.user.payment.management.SecurityServiceImpl;
import com.dz.user.payment.management.service.UserManagementSevice;

@Controller
public class UserManagementController {
	
	@Autowired
	UserManagementSevice userManagementService;
	
	@Autowired
	SecurityServiceImpl securityService;

    @RequestMapping(value = "/login")
    public String login(Map<String, Object> model) {
        return "login";
    }
    
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String register(Map<String, Object> model,
    		@RequestParam String username, @RequestParam String password, @RequestParam String confirmPassword) {
    	if (password == null) {
    		model.put("registrationError", "Wrong password, password should not be empty");
    		return "forward:/login";
    	}
    	if (!password.equals(confirmPassword)) {
    		model.put("registrationError", "Password and confirmPassword does not match");
    		return "forward:/login";
    	}
    	
    	try {
    		userManagementService.createUser(username, password);
    		securityService.autologin(username, password);
    		return "redirect:/search-cards";
    	} catch (Exception e) {
    		model.put("registrationError", e.getMessage());
    		return "forward:/login";
    	}
        
    }
	
	@RequestMapping(value = {"/", "index"})
	public String index(Map<String, Object> model) {
		return "index";
	}
	
}
