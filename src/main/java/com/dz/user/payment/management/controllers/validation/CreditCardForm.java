package com.dz.user.payment.management.controllers.validation;

import javax.validation.GroupSequence;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import com.dz.user.payment.management.controllers.validation.checks.AdvancedChecks;
import com.dz.user.payment.management.controllers.validation.checks.FieldChecks;

@GroupSequence({FieldChecks.class, AdvancedChecks.class, CreditCardForm.class})
@DateInFuture(monthField="month", yearField="year", message="{futureDate.card}", groups=AdvancedChecks.class)
public class CreditCardForm {

	@NotNull(message="{notempty.card.number}",groups=FieldChecks.class)
	@NotBlank(message="{notempty.card.number}",groups=FieldChecks.class)
	@Pattern(regexp = "^[\\p{Digit}]{13,19}$", message="{pattern.card.number}",groups=FieldChecks.class)
	private String number;
	
	@NotNull(message = "{notempty.card.name}",groups=FieldChecks.class)
	@NotBlank(message = "{notempty.card.name}",groups=FieldChecks.class)
	private String name;
	
	@NotNull(message = "{notempty.card.month}",groups=FieldChecks.class)
	@NotBlank(message = "{notempty.card.month}",groups=FieldChecks.class)
	@Pattern(regexp = "^(0[1-9]|1[012])$", message="{pattern.card.month}",groups=FieldChecks.class)
	private String month;
	
	@NotNull(message = "{notempty.card.year}",groups=FieldChecks.class)
	@NotBlank(message = "{notempty.card.year}",groups=FieldChecks.class)
	@Pattern(regexp = "^[\\p{Digit}]{2}$", message="{pattern.card.year}",groups=FieldChecks.class)
	private String year;

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMonth() {
		return month;
	}

	public void setMonth(String month) {
		this.month = month;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}
	
	
	
}
