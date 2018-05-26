package Median;

public class CheckingAccount extends Account {

	private double overdraftProtection;
	
	public CheckingAccount(double balance) {
		super(balance);
	}
	
	public CheckingAccount(double balance, double overdraftProtection) {
		super(balance);
		this.overdraftProtection = overdraftProtection;
	}
	
	public void withdraw(double amt) throws OverDraftException {
		if (amt - this.balance > overdraftProtection) {
			throw new OverDraftException("Deficit", amt - (this.balance + overdraftProtection));
		}
		this.balance -= amt;
		if (amt - this.balance > 0)
			overdraftProtection += (this.balance - amt);
	}
	
}
