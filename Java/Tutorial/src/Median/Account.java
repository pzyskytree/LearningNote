package Median;

public class Account {

	protected double balance;
	
	public Account(double balance) {
		this.balance = balance;
	}
	
	public double getBalance() {
		return this.balance;
	}
	
	public void deposit(double amt) {
		this.balance += amt;
	}
	
	public void withdraw(double amt) throws OverDraftException{
		if (this.balance - amt < 0)
			throw new OverDraftException("Balance is not enough", amt -this.balance);
		this.balance -= amt;
	}
}
