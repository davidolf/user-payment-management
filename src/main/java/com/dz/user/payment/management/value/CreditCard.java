package com.dz.user.payment.management.value;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="creditcard")
public class CreditCard {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	@ManyToOne
	@JoinColumn(name="userid")
	private User user;
	@Column(unique=true,nullable=false)
	private String number;
	@Column(nullable=false)
	private String name;
	@Column(nullable=false,length=2)
	private String year;
	@Column(nullable=false,length=2)
	private String month;
	
	public CreditCard() { }
	
	public CreditCard(long id, User user, String number, String name, String month, String year) {
		super();
		this.id = id;
		this.user = user;
		this.number = number;
		this.name = name;
		this.year = year;
		this.month = month;
	}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}
	public String getMonth() {
		return month;
	}
	public void setMonth(String month) {
		this.month = month;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
	
}
