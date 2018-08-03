package com.dz.user.payment.management.service;

import java.util.List;

import javax.transaction.Transactional;
import javax.validation.ValidationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.dz.user.payment.management.jpa.CreditCardJpaRepository;
import com.dz.user.payment.management.value.CreditCard;
import com.dz.user.payment.management.value.User;
import com.dz.user.payment.management.value.UserLevel;

@Service
public class CreditCardManagementService {

	@Autowired
	CreditCardJpaRepository creditCardRepo;
	
	@Autowired
	UserManagementSevice userManagementService;
	
	public List<CreditCard> getAllCreditCards() {
		return creditCardRepo.findAll();
	}
	
	public List<CreditCard> searchInCards(String searchInNumber) {
		User user = getCurrentUser();
		if (UserLevel.ADMIN.equals(user.getLevel())) {
			return creditCardRepo.findByNumberContaining(searchInNumber);
		}
		return creditCardRepo.findByUserAndNumberContaining(user, searchInNumber);
	}
	
	@Transactional
	public void addOrEditCard(String number, String name, String month, String year) throws ValidationException {
		User user = getCurrentUser();
		CreditCard c = creditCardRepo.findByNumber(number);
		
		if (c == null) {
			//add credit card
			CreditCard cc = new CreditCard(0, user, number, name, month, year);
			creditCardRepo.save(cc);
		} else {
			//edit credit card
			if (!user.getName().equals(c.getUser().getName())) {
				throw new ValidationException("user");
			}
			
			if (!c.getName().equals(name)) {
				throw new ValidationException("name");
			}
			
			c.setMonth(month);
			c.setYear(year);
			
			creditCardRepo.save(c);		
		}
		
	}
	
	private User getCurrentUser() {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String name = authentication.getName();
		User user = userManagementService.getUser(name);
		return user;
	}
	
}
