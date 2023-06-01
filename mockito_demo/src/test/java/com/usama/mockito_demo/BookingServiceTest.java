package com.usama.mockito_demo;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.ArgumentMatchers.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.usama.mockito_demo.args_matcher.BookingRepository;
import com.usama.mockito_demo.args_matcher.BookingService;
import com.usama.mockito_demo.args_matcher.Ticket;

@ExtendWith(MockitoExtension.class)
public class BookingServiceTest {
	@Mock
	BookingRepository bookingRepository;
	
	@InjectMocks
	BookingService bookingService;
	
	@Test
	public void testBuyTicket() {
		
		BookingService bookingServiceSpy = spy(bookingService);
		
		bookingServiceSpy.buyTicket("ABCAB");
		
		verify(bookingServiceSpy).bookSeat(any(Ticket.class));
		
	}
	
	@Test
	public void testBookSeat() {
//		when(bookingRepository.getSeats(any(String.class))).thenReturn(Arrays.asList("12A", "12B","12C"));
//		
//		List<String> availableSeats = bookingRepository.getSeats("ABC");
//		
//		Assertions.assertTrue(availableSeats.contains("12A"));
		
		String ticketShowId = "TICKET:ID_1";
		Ticket ticket = new Ticket(ticketShowId);
		
		List<String> availableTicket = Arrays.asList(ticketShowId);
		
		when(bookingRepository.getSeats(anyString())).thenReturn(availableTicket);
		
		Assertions.assertTrue(bookingService.bookSeat(ticket));
		
	}
	

}
