package com.ps.springmvc.psbankApp.services;

import java.util.List;

import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ps.springmvc.psbankApp.dao.AccountDAO;
import com.ps.springmvc.psbankApp.model.Account;

@Service
public class AccountServiceImpl implements AccountService {

	@Autowired
	AccountDAO accountDAO;

	@Override
	@Transactional
	public boolean saveAccount(Account account) {

		return accountDAO.saveAccount(account);

	}

	@Override
	@Transactional
	public List<Account> getAccounts() {
		return accountDAO.getAccounts();

	}

	@Override
@Transactional
	public Account getAccount(int accNo) {
		return accountDAO.getAccount(accNo);
	}

	@Override
	public boolean deleteAccount(int accNo) {
		return accountDAO.deleteAccount(accNo);
	}

}
