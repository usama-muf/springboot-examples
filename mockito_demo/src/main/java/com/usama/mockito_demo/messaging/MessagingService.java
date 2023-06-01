package com.usama.mockito_demo.messaging;

import java.util.List;

public class MessagingService {

	
	public void sendEmail(String subject, List<String> emails) {
		System.out.println("Mail send with subject "+subject+" to : "+emails);
	}
	
	public void passengerNotify(int passengerId) {
		System.out.println("Notifying Passenger with Id: "+passengerId+" this He has boarded the train!");
	}
}
