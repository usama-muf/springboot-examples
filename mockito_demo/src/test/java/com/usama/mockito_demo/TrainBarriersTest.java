package com.usama.mockito_demo;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.BDDMockito.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import com.usama.mockito_demo.train.EmailService;
import com.usama.mockito_demo.train.PassengerRepository;
import com.usama.mockito_demo.train.TrainBarriers;

import net.bytebuddy.agent.utility.nullability.MaybeNull;

@ExtendWith(MockitoExtension.class)
public class TrainBarriersTest {

	
	@Mock
	EmailService emailServiceMock;
	
	@Mock
	PassengerRepository passengerRepositoryMock;
	
//	@InjectMocks
//	TrainBarriers trainBarriers;
	
	
	final int PASSENGER_ID = 3;
	
	@Test
	public void passengerEntryTest() {

		

		TrainBarriers trainBarriersTest = new TrainBarriers(emailServiceMock, passengerRepositoryMock);
		TrainBarriers trainBarriers = spy(trainBarriersTest);
		
		
		given(trainBarriers.passengerIsEligible(PASSENGER_ID)).willReturn(true);
		
		
//		trainBarriers.passengerEntry(PASSENGER_ID);
		


//		verify(passengerRepositoryMock).registerPassengerOnTrain(PASSENGER_ID);
		verify(emailServiceMock).passengerNotify(PASSENGER_ID);

		then(emailServiceMock).should().passengerNotify(PASSENGER_ID);
		
		//		Assertions.assertTrue(trainBarriers.passengerIsEligible(PASSENGER_ID));
//		verify(passengerRepositoryMock, atLeast(2)).registerPassengerOnTrain(PASSENGER_ID);

	}

}
