package com.usama.junit_demo.bank;

import static org.junit.jupiter.api.Assertions.*;
import java.time.Duration;
import java.time.temporal.ChronoUnit;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

@DisplayName("Test BankAccount Class")
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class BankAccountTest {
	static BankAccount bankAccount = new BankAccount(0, 0);

//	@Test
//	@DisplayName("Withdraw 500 Successfully")
//	@Order(value = 2)
//	public void testWithdraw() {
////		BankAccount bankAccount = new BankAccount(0, 0);
//		bankAccount.withdraw(500);
//		assertEquals(500, bankAccount.getBalance());
//	}

	@Test
	@Order(value = 1)
	public void testDeposit() {
		bankAccount.deposit(1000);
		assertEquals(1000, bankAccount.getBalance());
	}

	@Test
	@DisplayName("Test withdrawn below zero")
	public void testException() {
		BankAccount bankAccount = new BankAccount(230, 0);
//		bankAccount.withdraw(400);
		assertThrows(RuntimeException.class, () -> bankAccount.withdraw(1600));
	}

	@Test
	@DisplayName(" Test if it will not throw exception when withdrawing and depositing")
	public void testWithdrawAndDepositWithoutException() {
		BankAccount bankAccount = new BankAccount(500, 100);
		assertAll(() -> bankAccount.deposit(1200), () -> bankAccount.withdraw(500));
	}
	
	
	@DisplayName("Check Duration ")
	public void testTimeout() {
		BankAccount bankAccount = new BankAccount(500, 100);
		assertTimeout(Duration.of(0, ChronoUnit.MICROS) , ()-> bankAccount.deposit(120));
		
	}
	
//	@Test
//	@DisplayName("Test Activation account after Creation")
//	public void testActive() {
//		BankAccount bankAccount = new BankAccount(500, 10);
//		assumeFalse(bankAccount != null);
//		assertTrue(bankAccount.isActive());
//	}

}
