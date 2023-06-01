package com.usama.junit_demo.bank;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.RepetitionInfo;
import org.junit.jupiter.api.extension.ExtendWith;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(BankAccountParameterResolver.class)
public class BankAccountDITest {
		

	@RepeatedTest(value = 12)
	public void testDeposit(BankAccount bankAccount) {
		bankAccount.deposit(1000);
		assertEquals(1000, bankAccount.getBalance());
	}
	
	@RepeatedTest(15)
	@DisplayName("Withdraw 500 Successfully")
	public void testWithdraw(BankAccount bankAccount, RepetitionInfo repetitionInfo) {
		bankAccount.withdraw(0);
		assertEquals(0, bankAccount.getBalance());
		System.out.println("No: "+repetitionInfo.getCurrentRepetition()+" total: "+repetitionInfo.getTotalRepetitions());
	}

}
