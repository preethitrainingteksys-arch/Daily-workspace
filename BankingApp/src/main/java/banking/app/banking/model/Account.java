package banking.app.banking.model;

public class Account {
	private int accountnumber;
	private String holdername;
	private double balance;

	public Account(int accountnumber, String holdername, double balance) {
		this.accountnumber = accountnumber;
		this.holdername = holdername;
		this.balance = balance;

	}

	public int getAccountnumber() {
		return accountnumber;

	}

	public double getBalance() {
		return balance;
	}

	public void deposit(double amount) {
		if (amount <= 0) {
			throw new IllegalArgumentException("inavalid deposit");
		}
		balance += amount;
	}

	public void withdraw(double amount) {
		if (amount > balance) {
			throw new IllegalArgumentException("Insufficient balance");
		}
		balance -= amount;

	}
}
