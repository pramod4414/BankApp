package com.bv.serviceimpl;

import com.bv.model.SalaryAccount;
import com.bv.service.ITransaction;
import com.exception.common.InsfficientBalance;

public class SalaryAccountService implements ITransaction {
	SalaryAccount salaryAccount;
	

	public SalaryAccountService(SalaryAccount salaryAccount) {
		super();
		this.salaryAccount = salaryAccount;
	}

	@Override
	public void withdraw(double amount) {
		System.out.println("Before withdraw:" + salaryAccount.getBalance());
		if (amount < 0) {
			System.out.println("Amount cannot be negative");
		} else if (salaryAccount.getBalance() < amount) {
			try
			{
				throw new InsfficientBalance ("insufficient balance");
			}
			catch(InsfficientBalance e)
			{
				e.printStackTrace();
			}
			
		} else {
			salaryAccount.setBalance(salaryAccount.getBalance() - amount);
			System.out.println(amount + "" + "Amount deducted");
			System.out.println("Total_balance:" + salaryAccount.getBalance());
		}

	}

	@Override
	public void deposite(double amount) {

		System.out.println("Before Depoite: " + salaryAccount.getBalance());
		salaryAccount.setBalance(salaryAccount.getBalance() + amount);
		System.out.println(amount + " Rs. Amount credited");
		System.out.println("Total balance after deposite " + salaryAccount.getBalance());

	}

}
