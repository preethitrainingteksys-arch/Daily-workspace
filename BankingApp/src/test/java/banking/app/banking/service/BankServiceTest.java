package banking.app.banking.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import banking.app.banking.exception.BankingException;

class BankServiceTest {

	private BankService bank;

	@BeforeEach
	void setup() {
		bank = new BankService();
		bank.createAccount(1, "Anna", 1000);
	}

	@Test
	void testDeposit() {
		bank.deposit(1, 500);
		assertEquals(1500, bank.getAccount(1).getBalance());
	}

	@Test
	void testWithdraw() {
		bank.withdraw(1, 300);
		assertEquals(700, bank.getAccount(1).getBalance());
	}

	@Test
	void testInsufficientBalance() {
		assertThrows(IllegalArgumentException.class, () -> bank.withdraw(1, 2000));
	}

	@Test
	void testDuplicateAccount() {
		assertThrows(BankingException.class, () -> bank.createAccount(1, "Test", 500));
	}
	@Test
	void testAccountNotFound() {
	    assertThrows(BankingException.class, () -> bank.getAccount(999));    
	}
	@Test
	void testDepositInvalidAccount() {
	    assertThrows(BankingException.class, () -> bank.deposit(999, 100));
	}
	
	
	@Test
	void testWithdrawInvalidAccount() {
	    assertThrows(IllegalArgumentException.class, () -> bank.withdraw(999, 100));
	}
	@Test

	void testDepositNegativeAmount() {
	    assertThrows(IllegalArgumentException.class, () -> bank.deposit(1, -100));
	}

	@Test
	void testWithdrawNegativeAmount() {
	    assertThrows(IllegalArgumentException.class, () -> bank.withdraw(1, -50));
	}
	@Test
	void testWithdrawExactBalance() {
	    bank.withdraw(1, 1000);
	    assertEquals(0, bank.getAccount(1).getBalance());
	}
	@Test
	void testCreateMultipleAccounts() {
	    bank.createAccount(2, "Preethi", 2000);
	    assertEquals(2000, bank.getAccount(2).getBalance());
	}
	
}
