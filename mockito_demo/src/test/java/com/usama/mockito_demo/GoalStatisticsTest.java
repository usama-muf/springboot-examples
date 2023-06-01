package com.usama.mockito_demo;

import static org.mockito.Mockito.when;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assumptions.*;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class GoalStatisticsTest {
	
	@Mock
	GoalsService goalsServiceMock;
	
	@InjectMocks
	GoalStatistics goalStatisticsInject;
	
	@Test
	public void checkGoalsTest() throws Exception {
		
		String player = "player";

//		TOO much duplicate Code
//		when(goalsServiceMock.getGoals(player)).thenReturn(100);
//		Integer goalsHigh = goalStatisticsInject.goalsPerGame(player, 10);
//		assertEquals(10, goalsHigh);
//		
//		when(goalsServiceMock.getGoals(player)).thenReturn(10);
//		Integer goalsLow = goalStatisticsInject.goalsPerGame(player, 10);
//		assertEquals(1, goalsLow);
//		
//		when(goalsServiceMock.getGoals(player)).thenReturn(0);
//		assertThrows(Exception.class,()->goalStatisticsInject.goalsPerGame(player, 10));
		
//		using stubs
		
		when(goalsServiceMock.getGoals(player)).thenReturn(100).thenReturn(10).thenReturn(0);
		Integer goalsHigh = goalStatisticsInject.goalsPerGame(player, 10);
		assertEquals(10, goalsHigh);		
		
		Integer goalsLow = goalStatisticsInject.goalsPerGame(player, 10);
		assertEquals(1, goalsLow);
		
		assertThrows(Exception.class,()->goalStatisticsInject.goalsPerGame(player, 10));
		
		
		
	}

}
