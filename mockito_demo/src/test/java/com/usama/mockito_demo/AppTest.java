package com.usama.mockito_demo;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.doAnswer;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue()
    {
        assertTrue( true );
    }
    
    @Test 
    public void testingMockVsSpy() {
    	List<Integer> mockList = mock(List.class);
    	mockList.add(12);
//    	assertEquals(12, mockList.get(0));
    	
    	List<Integer> list = new ArrayList<>();
    	List<Integer> spyList = spy(list);
    	spyList.add(12);
    	assertEquals(12, spyList.get(0));
    	
    	
    }
    
    
    @Test
    public void testingFunctionalityWhen_ThenReturn() {
    	List mockList = mock(List.class);
    	when(mockList.size()).thenReturn(3);
    	assertEquals(3, mockList.size());
//    	System.out.println(mockList.get(5));
//    	assertThrows(RuntimeException.class, ()-> mockList.clear());
    }
    @Test
    public void testingFunctionalityDoReturn_When() {
    	List mockList = mock(List.class);
//    	doReturn(new RuntimeException()).when(mockList).clear();;
    	doNothing().when(mockList).clear();;
    	
//    	assertThrows(NullPointerException.class, ()-> mockList.clear());
//    	when(mockList.size()).thenReturn(3);
//    	assertEquals(new ArrayList<>(), mockList);
    }
    @Test
    public void testingFunctionalityDoAnswer_When() {
    	List mockList = mock(List.class);
//    	doReturn(new RuntimeException()).when(mockList).clear();;
    	doAnswer(i-> {
    		System.out.println(i);
    		return "Hi";
    	}).when(mockList).clear();
    	
    	
    	assertThrows(NullPointerException.class, ()-> mockList.clear());
//    	when(mockList.size()).thenReturn(3);
//    	assertEquals(new ArrayList<>(), mockList);
    }
}
