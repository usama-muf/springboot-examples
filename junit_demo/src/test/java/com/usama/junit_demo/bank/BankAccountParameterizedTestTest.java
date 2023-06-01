package com.usama.junit_demo.bank;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.ValueSource;

@ExtendWith(BankAccountParameterResolver.class)
public class BankAccountParameterizedTestTest {

	@ParameterizedTest
	@ValueSource(ints = { 12, 144, 100, 2000 })
	@DisplayName("Withdraw  Successfully")
	public void testDeposit(int amount, BankAccount bankAccount) {
		bankAccount.deposit(amount);
		assertEquals(amount, bankAccount.getBalance());
	}

//	@ParameterizedTest
//	@EnumSource(value = DayOfWeek.class)
//	public void testDayOfWeek(DayOfWeek dayOfWeek) {
//		assertTrue(dayOfWeek.toString().startsWith("T"));
//	}
//	
//	@ParameterizedTest //(name = "{index} ==> balance of ''{1}'' = {0}")
//	@CsvFileSource(resources = "/details.csv")
////	@DisplayName(value = "Display Name")
//	public void depositAndNameTest(double amount, String name, BankAccount bankAccount) {
//		bankAccount.deposit(amount);
//		bankAccount.setHolderName(name);
//		assertEquals(amount, bankAccount.getBalance());
//		assertEquals(name, bankAccount.getHolderName());
//		
//	}

}
