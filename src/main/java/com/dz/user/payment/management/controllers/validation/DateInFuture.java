package com.dz.user.payment.management.controllers.validation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Constraint(validatedBy = DateInFutureValidator.class)
@Target({ ElementType.TYPE })
@Retention(RetentionPolicy.RUNTIME)
public @interface DateInFuture {

	String message();
	String monthField();
	String yearField();
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
	
}
