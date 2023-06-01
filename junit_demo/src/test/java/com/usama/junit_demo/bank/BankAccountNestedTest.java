package com.usama.junit_demo.bank;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

public class BankAccountNestedTest {
//	static BankAccount bankAccount = new BankAccount(0, 0);


	@Test
	@DisplayName("Deposit 500 Successfully")
	public void testDeposit() {
		BankAccount bankAccount = new BankAccount(0, 0);
		bankAccount.deposit(1000);
		assertEquals(1000, bankAccount.getBalance());
	}
	@Test
	@DisplayName("Withdraw 500 Successfully")
	public void testWithdraw() {
		BankAccount bankAccount = new BankAccount(1000, 0);
		bankAccount.withdraw(500);
		assertEquals(500, bankAccount.getBalance());
	}

	@Nested
	class TestWhenAccountBal0 {

		@Test
		public void withdrawWhenBalanceIsZero() {
			BankAccount bankAccount = new BankAccount(0, 0);

			assertThrows(RuntimeException.class, () -> bankAccount.withdraw(1000));
		}

		@Test
		public void depositWhenBankBalanceIsNegative1000() {
			BankAccount bankAccount = new BankAccount(0, -1000);
			bankAccount.deposit(500);
			assertEquals(500, bankAccount.getBalance());

		}
	}

}
