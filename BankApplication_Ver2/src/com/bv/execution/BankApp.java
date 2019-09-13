package com.bv.execution;

import com.bv.model.SavingAccount;
import com.bv.serviceimpl.AccountService;
import com.bv.serviceimpl.SavingAccountsRepository;

public class BankApp {

	public static void main(String[] args) {

	/*	Account salAccount = new SavingAccount(102, "SalaryAccountHolder", 4000, true);
		Account savingAccount1 = new SavingAccount(101, "Parvati", 5000,false);
		
		SavingAccountService salaryAccountService = new SavingAccountService((SavingAccount) salAccount);
		salaryAccountService.chooseOperation();
		
		System.out.println("-------------------------------");
		
		SavingAccountService savingAccountService = new SavingAccountService((SavingAccount)savingAccount1);
		savingAccountService.chooseOperation();
		
		CurrentAccount currentAccount=new CurrentAccount(102, "SalaryAccountHolder", 4000);
		CurrentAccountService currentAccountService=new CurrentAccountService(currentAccount);
		currentAccountService.withdraw(20000);
		currentAccountService.deposite(30000);*/
		
		SavingAccountsRepository savingRepo = new SavingAccountsRepository();
		AccountService accountService = new AccountService();
		accountService.chooseOperation();
		System.out.println(savingRepo.getAllAccounts());
	
		SavingAccount savingAccount = new SavingAccount(103, "Kajal", 10000, true);
		savingRepo.getAccount(103);
		System.out.println(savingRepo.addAccount(savingAccount));
		System.out.println(savingRepo.getAllAccounts());
		System.out.println(savingRepo.removeAccount(102));
		System.out.println("After Deletion");
		System.out.println(savingRepo.getAllAccounts());
	}
}
		





