package com.bv.model;

public class CurrentAccount extends Account {
	
	private double creditLimit;
	private int acc_no;
	
	

	

	public void setAcc_no(int acc_no) {
		this.acc_no = acc_no;
	}

	public int getAcc_no() {
		return acc_no;
	}

	public CurrentAccount() {
		super();
		// TODO Auto-generated constructor stub
	}

	public double getCreditLimit() {
		return creditLimit;
	}

	public void setCreditLimit(double creditLimit){
		this.creditLimit = creditLimit;
	}

	public CurrentAccount(int acc_no, String holder_name, double balance) {
		super(acc_no, holder_name, balance);
		
		
	}
}

