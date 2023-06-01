package com.usama.junit_demo.bank;

import java.time.LocalDateTime;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TestableCodeTest {

    private static TestableCode tc = new TestableCode();
    @Test
    @DisplayName("Test greeting special name")
    public void testSpecialNameGreeting() {
        String name = "Noah";
        assertTrue(tc.greetUser(name).contains("VIP"));
    }

    @Test
    @DisplayName("Test greeting special and known name")
    public void testSpecialAndKnownNameGreeting() {
        String name = "Tess";
        assertTrue(tc.greetUser(name).contains("even"));
    }

    @Test
    @DisplayName("Test greeting unknown name")
    public void testUnknownNameGreeting() {
        String name = "Sascha";
        assertTrue(tc.greetUser(name).contains("stranger"));
    }

    @Test
    @DisplayName("Test part of the day greeting")
    public void testDayPart() {
    	LocalDateTime dateTime = LocalDateTime.of(2023, 4, 24, 17, 12);
    	String greeting = "Good Afternoon, ";
       assertEquals(greeting, tc.greetings(dateTime));
    }
}