package dev.whydn.dao;

import dev.whydn.constants.MessageConstant;
import models.Car;
import org.junit.Test;

import static org.junit.Assert.*;

public class ParkingLotDaoMapTest {

    public static final int capacity = 2;

    public static final String LICENSE_PLATE_ONE = "KA-01-HH-1234";

    public static final Car carOne = new Car(LICENSE_PLATE_ONE);

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

    @Test
    public void park_should_able_toParking_a_car_when_have_oneSlot_null() {
        Integer expectedAllocatedSlot = 1;

        ParkingLotDao parkingLotDao = ParkingLotDaoMap.createParkingLotDaoMap(capacity);
        parkingLotDao.generateParkingLot();

        String expectedResult = String.format(MessageConstant.PARKING_SUCCESS, expectedAllocatedSlot);
        String actualResult = parkingLotDao.park(carOne);

        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void park_should_notAble_toParking_a_car_when_there_noSlot() {
        ParkingLotDao parkingLotDao = ParkingLotDaoMap.createParkingLotDaoMap(0);
        parkingLotDao.generateParkingLot();

        String expectedResult = MessageConstant.PARKING_LOT_FULL;
        String actualResult = parkingLotDao.park(carOne);

        assertEquals(expectedResult, actualResult);
    }
}