package com.usama.junit_demo.bank;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;

@Execution(ExecutionMode.CONCURRENT)
@ExtendWith(BankAccountParameterResolver.class)
public class BankAccountParallelExecutionTest {
	
	@Test
	@DisplayName("Depositing 500 Successfully")
	public void testDeposit(BankAccount bankAccount) {
		
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		bankAccount.deposit(500);
		assertEquals(500, bankAccount.getBalance());
	}
	@DisplayName("Depositing 500 Successfully")
	
	@Test
	public void testDeposit1(BankAccount bankAccount) {
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		bankAccount.deposit(500);
		assertEquals(500, bankAccount.getBalance());
	}
	@DisplayName("Depositing 500 Successfully")

	@Test
	public void testDeposit11(BankAccount bankAccount) {
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		bankAccount.deposit(500);
		assertEquals(500, bankAccount.getBalance());
	}
	@DisplayName("Depositing 500 Successfully")
	
	@Test
	public void testDeposit111(BankAccount bankAccount) {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		bankAccount.deposit(500);
		assertEquals(500, bankAccount.getBalance());
	}
	@DisplayName("Depositing 500 Successfully")
	
	@Test
	public void testDeposit12(BankAccount bankAccount) {
		try {
			Thread.sleep(1500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		bankAccount.deposit(500);
		assertEquals(500, bankAccount.getBalance());
	}
	@DisplayName("Depositing 500 Successfully")
	
	@Test
	public void testDeposit13(BankAccount bankAccount) {
		bankAccount.deposit(500);
		assertEquals(500, bankAccount.getBalance());
	}

}
