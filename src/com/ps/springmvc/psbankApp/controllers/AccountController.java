package com.ps.springmvc.psbankApp.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.ps.springmvc.psbankApp.model.Account;
import com.ps.springmvc.psbankApp.services.AccountService;

@Controller

public class AccountController {

	@Autowired
	AccountService accountService;

	@InitBinder
	public void initBinder(WebDataBinder dataBinder) {
		StringTrimmerEditor editor = new StringTrimmerEditor(true);
		dataBinder.registerCustomEditor(String.class, editor);
	}

	@RequestMapping("/")

	public String homePage(Model model) {
		return "homepage";
	}

	// @RequestMapping("/new/{username}")
	@RequestMapping("/new")
	public String newAccount(
			/*
			 * @PathVariable(value="username", required=false) String username,
			 */Model model) {

		// System.out.println(username);
		model.addAttribute("account", new Account());
		return "account-form";
	}

	@RequestMapping("/showAccount")
	public String showAccount() {
		return "showAccount";

	}

	@RequestMapping(value = "saveAccount", method = RequestMethod.POST)

	public String saveAccount(@Valid @ModelAttribute("account") Account account, BindingResult result) {

		System.out.println("acno " + account.getAccountnumber());
		System.out.println("tyoe " + account.getAccounttype());
		System.out.println("name " + account.getHoldername());
		System.out.println("code " + account.getPscode());
		System.out.println("dob " + account.getDob());
		System.out.println("bal " + account.getBalance());

		System.out.println("error count " + result.getErrorCount());

		/*
		 * if (result.hasErrors()) {
		 * 
		 * return "account-form"; } else { accountService.saveAccount(account);
		 * return "redirect:/list"; }
		 */
		if (result.hasErrors()) {
			return "account-form";
		} else {
			String messsage = "";
			boolean flage = true;
			try {
				flage = accountService.saveAccount(account);
			} catch (Exception e) {
				// TODO: handle exception
				messsage = e.getMessage();
				e.printStackTrace();
				flage = false;
			}
			if (!flage) {
				return "account-form";
			} else {
				accountService.saveAccount(account);
				return "redirect:/list";
			}
		}

	}

	@GetMapping("/edit")
	public String updateAccount(@RequestParam("accountnumber") int accountnumber, Model model) {

		Account account = accountService.getAccount(Integer.valueOf(accountnumber));

		model.addAttribute("account", account);
		return "account-form";
	}

	@GetMapping("/delete")
	public String deleteAccount(@RequestParam("accountnumber") int accountnumber) {

		accountService.deleteAccount(accountnumber);
		return "redirect:/list";

	}

	@GetMapping("/list")
	public String listAccounts(Model model) {

		List<Account> list = accountService.getAccounts();

		model.addAttribute("accounts", list);
		Authentication auth=SecurityContextHolder.getContext().getAuthentication();
		String name=auth.getName();
		model.addAttribute("username",name);
		return "listAccounts";
	}

	// @RequestMapping(value = "saveAccount", method = RequestMethod.POST)
	//
	// public String saveAccount(Model model, /*
	// *
	// * @RequestParam("accountnumber") String accountnumber,
	// *
	// * @RequestParam("holdername") String holdername,
	// *
	// * @RequestParam("balance") String balance
	// */
	//
	// Account account) {
	//
	// String accountnumber = request.getParameter("accountnumber");
	// String holdername = request.getParameter("holdername");
	// String balance = request.getParameter("balance");

	// model.addAttribute("accountnumber", accountNo);
	// model.addAttribute("holdername", holdername);
	// model.addAttribute("balance", balance);

	// Account account = new Account();
	// account.setAccountnumber(Integer.parseInt(accountnumber));
	// account.setHoldername(holdername);
	// account.setBalance(Integer.parseInt(balance));
	//
	// model.addAttribute("account",account);
	//
	// }

	@RequestMapping("*")
	public String fileNotFound() {

		return "filenotfound";
	}

}
