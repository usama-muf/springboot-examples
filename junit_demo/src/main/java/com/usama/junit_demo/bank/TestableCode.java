package com.usama.junit_demo.bank;

import java.time.LocalDateTime;
import java.util.Arrays;

public class TestableCode {
	public static String[] knownNames = { "Zeynep", "Tess", "Marina", "Jade", "Eric", "Jamal", "Malika", "James" };
	public static String[] specialNames = { "Zach", "Martin", "Noah", "Tess" };
	public String greeting = "";
	LocalDateTime dateTime = LocalDateTime.now();

	public String greetings(LocalDateTime dateTime) {
		if (dateTime.getHour() >= 0 && dateTime.getHour() < 6)
			return "Good night, ";

		else if (dateTime.getHour() >= 6 && dateTime.getHour() < 12)
			return "Good Morning, ";

		else if (dateTime.getHour() >= 12 && dateTime.getHour() < 18)
			return "Good Afternoon, ";

		else // if (dateTime.getHour() >= 18 && dateTime.getHour() <= 23)
			return "Good Evening, ";

	}

	public String greetUser(String name) {
		String greeting = greetings(dateTime) ;
		if (Arrays.stream(knownNames).anyMatch(name::equals)) {
			greeting += "I know you, " + name + ".";
			if (Arrays.stream(specialNames).anyMatch(name::equals)) {
				greeting += "You're even on our VIP list!";
			}
		} else if (Arrays.stream(specialNames).anyMatch(name::equals)) {
			greeting += "I don't know you, " + name + ". But you are on our VIP list!";
		} else {
			greeting += "stranger";
		}
		System.out.println(greeting);
		return greeting;
	}
}