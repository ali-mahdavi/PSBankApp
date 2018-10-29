package com.ps.springmvc.psbankApp.services;

import java.util.List;

import com.ps.springmvc.psbankApp.model.Account;

public interface AccountService {

	public boolean saveAccount(Account account);

	public List<Account> getAccounts();

	public Account getAccount(int accNo);

	public boolean deleteAccount(int accNo);

}
