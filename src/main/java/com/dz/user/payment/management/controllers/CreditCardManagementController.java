package com.dz.user.payment.management.controllers;

import java.util.List;
import java.util.Map;

import javax.validation.Valid;
import javax.validation.ValidationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.dz.user.payment.management.controllers.validation.CreditCardForm;
import com.dz.user.payment.management.service.CreditCardManagementService;
import com.dz.user.payment.management.value.CreditCard;

@Controller
public class CreditCardManagementController {

	@Autowired
	CreditCardManagementService creditCardService;
	
    @RequestMapping(value = "/search-cards")
    public String searchCards(Map<String, Object> model,
    			@RequestParam(required=false) String search) {
    	if (search != null && search.length() > 0) {
    		List<CreditCard> list = creditCardService.searchInCards(search);
    		long userCount = list.stream().map(c -> c.getUser().getName()).distinct().count();
    		if (userCount > 1) {
    			model.put("showUsers", true);
    		} else {
    			model.put("showUsers", false);
    		}
    		model.put("cards", list);
    	}
        return "search-cards";
    }
    
    @GetMapping(value = "/add-edit-card")
    public String addEditCard(CreditCardForm creditCardForm) {
        return "add-edit-card";
    }
    
    @PostMapping(value = "/add-edit-card")
    public String addEditCard(@Valid CreditCardForm creditCardForm, BindingResult bindingResult) {
    	if (bindingResult.hasErrors()) {
    		return "add-edit-card";
    	}
    	
    	try {
    		creditCardService.addOrEditCard(creditCardForm.getNumber(), creditCardForm.getName(),
    										creditCardForm.getMonth(), creditCardForm.getYear());
        	return "redirect:/search-cards";
    	} catch (ValidationException e) {
    		if ("user".equals(e.getMessage())) {
    			bindingResult.addError(new ObjectError("creditCardForm", "Trying to change credit card created by another user"));
    		} else if ("name".equals(e.getMessage())){
    			bindingResult.addError(new FieldError("creditCardForm", "name", "Trying to edit owner of credit card which is not allowed"));
    		}
    		return "add-edit-card";
    	}
    }
	
}
