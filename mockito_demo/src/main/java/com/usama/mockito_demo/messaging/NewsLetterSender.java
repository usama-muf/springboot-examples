package com.usama.mockito_demo.messaging;

import java.util.List;


public class NewsLetterSender {

	private SubscriberDatabase subscriberDatabase;
	private MessagingService messagingEngine;

	public NewsLetterSender(SubscriberDatabase subscriberDatabase, MessagingService messagingEngine) {
		this.subscriberDatabase = subscriberDatabase;
		this.messagingEngine = messagingEngine;
	}

	public void sendNewsLetter(String subject) {
		List<String> emails = subscriberDatabase.getSubscribers();
		if (emails.isEmpty())
			throw new ZeroSubscriberException();

		messagingEngine.sendEmail(subject, emails);
	}

	public int numberOfSubscriber() {
		System.out.println("Calling number of subscribers "+ subscriberDatabase.getSubscribers());
		return subscriberDatabase.getSubscribers().size();
	}

	public List<String> getSubscribersEmail() {
		return subscriberDatabase.getSubscribers();
	}

	public MessagingService getMessagingEngine() {
		return this.messagingEngine;
	}

}
