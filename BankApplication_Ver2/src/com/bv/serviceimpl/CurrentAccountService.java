
package com.bv.serviceimpl;

import java.util.Scanner;

import com.bv.model.CurrentAccount;
import com.bv.service.ITransaction;

public class CurrentAccountService implements ITransaction {
	
	CurrentAccount currentAccount;
	double originalCreditLimit;
	public CurrentAccountService(CurrentAccount currentAccount) {
		super();
		this.currentAccount = currentAccount;
		set();
		
	}

	public void set()
	{
		currentAccount.setAcc_type("current");
		currentAccount.setCreditLimit(50000);
		originalCreditLimit=currentAccount.getCreditLimit();
	}
	
	@Override
	public void withdraw(double amount) {
		double balance=currentAccount.getBalance()-amount;
		double creditLimit=currentAccount.getCreditLimit();
		if(amount >currentAccount.getBalance()+creditLimit  )
		{
			
			System.out.println("Invalid funds ");
		}
		else
		if (balance >= 0)
		{
			currentAccount.setBalance(balance);
			System.out.println("Your account XXXXXXX" + currentAccount.getAcc_no() % 10 + " has been debited with Rs." + amount);
			System.out.println("and Your account balance is " + currentAccount.getBalance() +"\n"+"And your credit limit is "+currentAccount.getCreditLimit());
		}
		else if (balance < 0)
		{
			currentAccount.setBalance(balance);
			currentAccount.setCreditLimit(creditLimit+balance);
			System.out.println("Your account XXXXXXX" + currentAccount.getAcc_no() % 10 + " has been debited with Rs." + amount);
			System.out.println("and Your account balance is " + currentAccount.getBalance()+"\n"+"And your credit limit is "+currentAccount.getCreditLimit());
		}
		else
		{
			System.out.println("Invalid transaction you exceed credit limit");
		}
			
		
			
	}

	@Override
	public void deposite(double amount) {
		
		
		if (currentAccount.getBalance() < 0)
		{
			double bal=currentAccount.getCreditLimit()+amount-originalCreditLimit;
			currentAccount.setCreditLimit(originalCreditLimit);
			currentAccount.setBalance(bal);
			System.out.println("Your account XXXXXXX" + currentAccount.getAcc_no() % 10 + " has been credited with Rs." + amount);
			System.out.println("and Your account balance is " + currentAccount.getBalance() +"\n"+"And your credit limit is "+currentAccount.getCreditLimit());
		}
		else
		{
			currentAccount.setBalance(amount);
			System.out.println("Your account XXXXXXX" + currentAccount.getAcc_no() % 10 + " has been credited with Rs." + amount);
			System.out.println("and Your account balance is " + currentAccount.getBalance() +"\n"+"And your credit limit is "+currentAccount.getCreditLimit());
			
		}
		
	}
	
	public void chooseOperation() {
		Scanner sc = null;
		int choice;
		boolean flag = true;
			while (flag) {

				System.out.println("\n" + "Select one of the options below");
				System.out.println("1. Withdraw" + "\n" + "2. Deposite" + "\n" + "3. Display Details" + "\n" + "4. Exit");
				sc = new Scanner(System.in);
				choice = sc.nextInt();
				switch (choice) {
				case 1: {
					System.out.println("Enter amount to be withdraw\n");
					withdraw(sc.nextDouble());
					break;
				}

				case 2: {
					System.out.println("Enter amount to be deposite\n");
					deposite(sc.nextDouble());
					break;
				}
				case 3:
					System.out.println("Holder name: "+currentAccount.getHolder_name());
					System.out.println("Account number: "+currentAccount.getAcc_no());
					System.out.println("Account Type name: "+currentAccount.getAcc_type());
					System.out.println("Account Balance: "+currentAccount.getBalance());
					break;

				case 4: {
					System.out.println("Transaction complete\n");
					flag = false;
					 break;
				}
				default: {
					System.out.println("Enter Valid operation\n");
					break;
				}
				}

			}

	}
}
