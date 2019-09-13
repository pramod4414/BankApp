package com.bv.service;

import com.exception.common.InsfficientBalance;

public interface ITransaction {

	public void withdraw(double amount) throws InsfficientBalance ;
	public void deposite(double amount);
	
}
