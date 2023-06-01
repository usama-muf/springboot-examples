package org.example;

import org.junit.Before;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class BookingManagerTest {

    private static HotelDao hotelDaoMock;
    private static BookingManager bookingManager;

    @BeforeAll
    public static void setup() throws Exception {

        hotelDaoMock = mock(HotelDao.class);
        bookingManager = new BookingManager(hotelDaoMock);

        List<String> availableRooms = Arrays.asList("A");
        when(hotelDaoMock.fetchAvailableRooms()).thenReturn(availableRooms);

    }

    @Test
    public void checkAvailableRoomsTrue()  {
        try {
        assertTrue(bookingManager.checkRoomAvailability("A"));
        }
        catch (Exception e) {
            System.out.println(e);
        }
    }

    @Test
    public void checkAvailableRoomsFalse() throws SQLException {
        assertFalse(bookingManager.checkRoomAvailability("B"));
    }
}