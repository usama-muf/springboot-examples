package com.usama.mockito_demo;

import com.usama.mockito_demo.messaging.MessagingService;
import com.usama.mockito_demo.messaging.NewsLetterSender;
import com.usama.mockito_demo.messaging.SubscriberDatabase;

/**
 * Hello world!
 *
 */
public class App {

	public static void main(String[] args) {

		SubscriberDatabase database = new SubscriberDatabase();
		MessagingService engine = new MessagingService();
		NewsLetterSender sender = new NewsLetterSender(database, engine);

		try {
			sender.sendNewsLetter("New Offers Unlocked");

		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("Hello World!");
	}
}
