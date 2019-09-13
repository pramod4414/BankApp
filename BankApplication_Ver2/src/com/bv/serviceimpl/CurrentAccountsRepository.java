package com.bv.serviceimpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.bv.database.DatabaseClass;
import com.bv.model.Account;
import com.bv.model.CurrentAccount;
import com.bv.model.SavingAccount;

public class CurrentAccountsRepository {
	
private Map<Integer, CurrentAccount> currentAccounts= DatabaseClass. getCurrentAccount();
	
	public CurrentAccountsRepository() {
		currentAccounts.put(105, new CurrentAccount(105, "Parvati", 5000));
		currentAccounts.put(106, new CurrentAccount(106, "Par", 5000));
	}
	
	// select all statement in sql
	//select * from accounts
	public List<CurrentAccount> getAllAccounts()
	{
		return new ArrayList<CurrentAccount>(currentAccounts.values());
	}
	//select * from accounts where acc_no = ?
	public void getAccount(int acc_no)
	{
		
			Account CurrentAccount = currentAccounts.get(acc_no);
			 
			CurrentAccountService CurrentAccountService = new
					CurrentAccountService((CurrentAccount) CurrentAccount);
			CurrentAccountService.chooseOperation();
//			return savingAccounts.get(acc_no);
		
	}
	public CurrentAccount addAccount(CurrentAccount currentAccount) {
		currentAccount.setAcc_no(currentAccount.getAcc_no()+0);
		currentAccounts.put(currentAccount.getAcc_no(),currentAccount);
		return currentAccount;
	}
	
	public Account updateAccount(CurrentAccount currentAccount)
	{
		if(currentAccount.getHolder_name().isEmpty())
		{
			return null;
		}
		currentAccounts.put(currentAccount.getAcc_no(), currentAccount);
		return currentAccount;
			
	}
	public Account removeAccount(int acc_no)
	{
		return currentAccounts.remove(acc_no);
	}

}
