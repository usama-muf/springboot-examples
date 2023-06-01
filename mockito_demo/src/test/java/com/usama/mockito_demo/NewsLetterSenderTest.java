package com.usama.mockito_demo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.usama.mockito_demo.messaging.MessagingService;
import com.usama.mockito_demo.messaging.NewsLetterSender;
import com.usama.mockito_demo.messaging.SubscriberDatabase;
import com.usama.mockito_demo.messaging.ZeroSubscriberException;

public class NewsLetterSenderTest {

	private static MessagingService messagingEngine; 
	private static SubscriberDatabase subscriberDatabase;
	private static NewsLetterSender sender;
	
	@BeforeAll
	public static void inti() {
		
		messagingEngine = mock(MessagingService.class);
		subscriberDatabase = mock(SubscriberDatabase.class);
		sender = new NewsLetterSender(subscriberDatabase, messagingEngine);
		
		List<String> emails = Arrays.asList("usama@usama.com", "tank@destroyer.com");
		when(subscriberDatabase.getSubscribers()).thenReturn(emails);
	}
	
	@Test
	public void subscriberDatabaseNotNull() {
		assertTrue(subscriberDatabase.getSubscribers().size()==2);
	}
	
	@Test 
	@DisplayName("Validating Number of Subscribers")
	public void numberOfSubscriberTest() {
		assertEquals(2, sender.numberOfSubscriber());
	}
	
	@Test
	public void zeroSubscribersThrow() {
		NewsLetterSender letterSender = new NewsLetterSender(new SubscriberDatabase(), new MessagingService());
		NewsLetterSender  letterSenderSpy= spy(letterSender);
//		doReturn(0).when(letterSenderSpy.numberOfSubscriber());
		when(letterSenderSpy.numberOfSubscriber()).thenThrow(ZeroSubscriberException.class);
//		letterSenderSpy.sendNewsLetter("hello");
		
	}
	
	
}
