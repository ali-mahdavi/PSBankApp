package com.ps.springmvc.psbankApp.model;

import java.util.Date;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Repository;

import com.ps.springmvc.psbankApp.validations.*;

public class Account {

	@NotNull
	private Integer accountnumber;
	
	@NotNull(message = "Account holder name can not be blank")
	@Size(min=2,max=20,message="invalid length for holdername")
	@Pattern(regexp="[A-Za-z(\\s)]+",message="invalid format for account holder name")
	private String holdername;
	
	@NotNull(message = "Balance Amount is required")
	@Min(value=5000, message="account balance can not be less than 5000")
	private Integer balance;
	
	@NotNull(message = "Account type can not be null")
	private String accounttype;

	@NotNull(message = "Date of birth can not be null")
	@DateTimeFormat(pattern = "MM/dd/yyyy")
	@Past(message="dat of birth can not be from future")
	private Date dob;
	
	@NotNull(message="PS code is required")
	@PSCode
	private String pscode;

	
	public Account() {
		accountnumber = 0;
		holdername = "";
		balance = 0;
	}

	public String getAccounttype() {
		return accounttype;
	}

	public Account(Integer accounNumber, String holdername, Integer balance) {
		this.accountnumber = accounNumber;
		this.holdername = holdername;
		this.balance = balance;
	}

	public void setAccounttype(String accounttype) {
		this.accounttype = accounttype;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public String getPscode() {
		return pscode;
	}

	public void setPscode(String pscode) {
		this.pscode = pscode;
	}

	public Integer getAccountnumber() {
		return accountnumber;
	}

	public void setAccountnumber(Integer accountnumber) {
		this.accountnumber = accountnumber;
	}

	public String getHoldername() {
		return holdername;
	}

	public void setHoldername(String holdername) {
		this.holdername = holdername;
	}

	public Integer getBalance() {
		return balance;
	}

	public void setBalance(Integer balance) {
		this.balance = balance;
	}

}
