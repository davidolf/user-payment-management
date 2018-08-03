package com.dz.user.payment.management.jpa;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dz.user.payment.management.value.CreditCard;
import com.dz.user.payment.management.value.User;

public interface CreditCardJpaRepository extends JpaRepository<CreditCard, String> {

	public List<CreditCard> findByUserAndNumberContaining(User user, String number);
	public List<CreditCard> findByNumberContaining(String number);
	public CreditCard findByNumber(String number);
}
