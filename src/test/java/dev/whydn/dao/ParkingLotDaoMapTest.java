package dev.whydn.dao;

import dev.whydn.constants.MessageConstant;
import org.junit.Test;

import static org.junit.Assert.*;

public class ParkingLotDaoMapTest {

    public static final int capacity = 6;

    @Test
    public void createParkingLotDaoMap_should_return_ParkingLotDaoClass() {
        Class expected = ParkingLotDaoMap.class;
        Class actual = ParkingLotDaoMap.createParkingLotDaoMap(capacity).getClass();

        assertEquals(expected, actual);
    }

    @Test
    public void generateParkingLot_Should_generate_return_parkingLotMessageSuccessFormat() {
        String expected = String.format(MessageConstant.CREATE_PARKING_LOT_SUCCESS, capacity);
        String actual = ParkingLotDaoMap.createParkingLotDaoMap(capacity).generateParkingLot();

        assertEquals(expected, actual);
    }
}