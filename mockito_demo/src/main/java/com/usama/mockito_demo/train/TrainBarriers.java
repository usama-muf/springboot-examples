package com.usama.mockito_demo.train;

public class TrainBarriers {

	private EmailService emailService;
	private PassengerRepository passengerRepository;

	public TrainBarriers(EmailService emailService, PassengerRepository passengerRepository) {
		super();
		this.emailService = emailService;
		this.passengerRepository = passengerRepository;
	}
	
	public void passengerEntry(int passengerId) {
		passengerRepository.registerPassengerOnTrain(passengerId);
		emailService.passengerNotify(passengerId);
	}
	
	public boolean passengerIsEligible(int passengerId) {
		return true;
	}

}
