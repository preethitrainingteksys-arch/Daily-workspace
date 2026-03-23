package banking.app.banking.service;
 
import java.util.HashMap;

import java.util.Map;

import banking.app.banking.exception.BankingException;
import banking.app.banking.model.Account;
 
public class BankService {

	private Map<Integer, Account> accounts = new HashMap<>();
 
	public void createAccount(int accNo, String name, double balance) {

		if (accounts.containsKey(accNo)) {

			throw new BankingException("Account already exists");

		}

		accounts.put(accNo, new Account(accNo, name, balance));
 
	}
 
	public Account getAccount(int accountNumber
			) {

		Account account = accounts.get(accountNumber);

		if (account == null) {

			throw new IllegalArgumentException("Account not found");

		}

		return account;

	}
 
	public void deposit(int accountNumber, double amount) {

		getAccount(accountNumber).deposit(amount);

	}
 
	public void withdraw(int accountNumber, double amount) {

		getAccount(accountNumber).withdraw(amount);

	}

}

 