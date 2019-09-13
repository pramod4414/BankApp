package com.bv.serviceimpl;

import java.util.Scanner;

import com.bv.model.Account;
import com.bv.model.SavingAccount;

public class AccountService {
	SavingAccountService savingAccountService;
	CurrentAccountService currentAccountService;
	SavingAccountsRepository savingAccountsRepository;
	


	public void chooseOperation() {
		Scanner sc = null;
		int choice;
		boolean flag = true;
		while (flag) {

			System.out.println("\n" + "Select one of the options below");
			System.out.println("1. Saving" + "\n" + "2. Current" + "\n");
			sc = new Scanner(System.in);
			choice = sc.nextInt();
			switch (choice) {
			case 1: {
				System.out.println("saving account selected");
				System.out.println("Enter the account number");
				
				int acc_no=sc.nextInt();
				
				SavingAccountsRepository savingRepo = new SavingAccountsRepository();
				savingRepo.getAccount(acc_no);
				break;
			}

			case 2: {
				System.out.println("current account selected");
				System.out.println("Enter the account number");
				
				int acc_no=sc.nextInt();
				CurrentAccountsRepository currentRepo = new CurrentAccountsRepository();
				currentRepo.getAccount(acc_no);
				break;
			}
			default: {
				System.out.println("Enter Valid Account"+"\n");
				break;
			}
			}
		}
	}

}
