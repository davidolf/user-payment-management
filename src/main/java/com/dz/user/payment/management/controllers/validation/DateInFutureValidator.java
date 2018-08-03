package com.dz.user.payment.management.controllers.validation;

import java.time.LocalDate;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.BeanWrapperImpl;

public class DateInFutureValidator implements ConstraintValidator<DateInFuture, Object> {

    private String monthField;
    private String yearField;
 
    public void initialize(DateInFuture annotation) {
        this.monthField = annotation.monthField();
        this.yearField = annotation.yearField();
    }
	
	@Override
	public boolean isValid(Object value, ConstraintValidatorContext context) {
		String monthValue = (String) new BeanWrapperImpl(value).getPropertyValue(monthField);
		String yearValue = (String) new BeanWrapperImpl(value).getPropertyValue(yearField);
		
		Integer month = Integer.parseInt(monthValue);
		Integer year = Integer.parseInt(yearValue) + 2000;
		
		LocalDate initial = LocalDate.of(year,month,1);
		LocalDate lastDayOfMonth = initial.withDayOfMonth(initial.lengthOfMonth());
		
		LocalDate now = LocalDate.now().withDayOfMonth(1);
		if (now.isBefore(lastDayOfMonth)) {
			return true;
		}
		return false;
	}

	
	
}
