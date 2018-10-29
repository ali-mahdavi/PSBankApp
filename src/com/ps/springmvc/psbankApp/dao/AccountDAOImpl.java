package com.ps.springmvc.psbankApp.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ps.springmvc.psbankApp.entity.AccountEntity;
import com.ps.springmvc.psbankApp.model.Account;

@Repository
public class AccountDAOImpl implements AccountDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public boolean saveAccount(Account account) {
		boolean saveFlag = true;

		AccountEntity accountEntity = new AccountEntity();

		accountEntity.setAccountnumber(account.getAccountnumber());
		accountEntity.setHoldername(account.getHoldername());
		accountEntity.setAccounttype(account.getAccounttype());
		accountEntity.setBalance(account.getBalance());
		accountEntity.setDob(account.getDob());
		accountEntity.setPscode(account.getPscode());

		try {
			Session session = sessionFactory.getCurrentSession();
			//session.saveOrUpdate(accountEntity);
			session.save(accountEntity);
		} catch (Exception ex) {
			ex.printStackTrace();
			saveFlag = false;
		}
		return saveFlag;
	}

	@Override
	public List<Account> getAccounts() {
		List<Account> list = new ArrayList<Account>();
		try {
			Session session = sessionFactory.getCurrentSession();
			Query<AccountEntity> query = session.createQuery("FROM AccountEntity", AccountEntity.class);
			List<AccountEntity> result = query.getResultList();

			for (AccountEntity entity : result) {
				Account account = new Account();
				account.setAccountnumber(entity.getAccountnumber());
				account.setHoldername(entity.getHoldername());
				account.setBalance(entity.getBalance());
				account.setDob(entity.getDob());
				account.setPscode(entity.getPscode());
				list.add(account);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;
	}

	@Override
	public Account getAccount(int accNo) {
		Account account =new Account();
		try {
			Session session = sessionFactory.getCurrentSession();
//			Query<AccountEntity> query = session.createQuery("FROM AccountEntity A WHERE A.accountnumber =" + accNo,
//					AccountEntity.class);
//
//			AccountEntity entity = query.getSingleResult();

			
			AccountEntity entity = session.get(AccountEntity.class,accNo);
			if(entity==null) {
				return null;
			}
			account.setAccountnumber(entity.getAccountnumber());
			account.setHoldername(entity.getHoldername());
			account.setBalance(entity.getBalance());
			account.setDob(entity.getDob());
			account.setPscode(entity.getPscode());


		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return account;
	}

	@Override
	@Transactional
	public boolean deleteAccount(int accNo) {
		boolean deleted= true;
		try {
			Session session =sessionFactory.getCurrentSession();
			AccountEntity entity = session.load(AccountEntity.class, accNo);
			session.delete(entity);
		}
		catch(Exception ex) {
			ex.printStackTrace();
			deleted=false;
		}
		return deleted;
	
	}

}
