package com.ps.springmvc.psbankApp.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Account")
public class AccountEntity {

	@Id
	@Column(name="accountnumber")
	private Integer accountnumber;

	@Column(name="holdername")
	private String holdername;

	@Column(name="balance")
	private Integer balance;

	@Column(name="accounttype")
	private String accounttype;

	@Column(name="dob")
	private Date dob;

	@Column(name="pscode")
	private String pscode;

	public AccountEntity() {
	
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

	public String getAccounttype() {
		return accounttype;
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
	
	
}
