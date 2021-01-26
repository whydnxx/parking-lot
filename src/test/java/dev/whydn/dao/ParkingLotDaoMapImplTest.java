package dev.whydn.dao;

import dev.whydn.constants.MessageConstant;
import dev.whydn.models.Car;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

public class ParkingLotDaoMapImplTest {

    public static final int capacity = 2;

    public static final String LICENSE_PLATE_ONE = "KA-01-HH-1234";
    public static final String LICENSE_PLATE_TWO = "KA-01-HH-1234";

    public static final Car carOne = Car.createCar(LICENSE_PLATE_ONE);
    public static final Car carTwo = Car.createCar(LICENSE_PLATE_TWO);

    @Test
    public void createParkingLotDaoMap_should_return_ParkingLotDaoClass() {
        Class expected = ParkingLotDaoMapImpl.class;
        Class actual = ParkingLotDaoMapImpl.createParkingLotDaoMap(capacity).getClass();

        assertEquals(expected, actual);
    }

    @Test
    public void generateParkingLot_Should_generate_return_parkingLotMessageSuccessFormat() {
        String expected = String.format(MessageConstant.CREATE_PARKING_LOT_SUCCESS, capacity);
        String actual = ParkingLotDaoMapImpl.createParkingLotDaoMap(capacity).generateParkingLot();

        assertEquals(expected, actual);
    }

    @Test
    public void park_should_able_toParking_a_car_when_have_oneSlot_null() {
        Integer expectedAllocatedSlot = 1;

        ParkingLotDao parkingLotDao = ParkingLotDaoMapImpl.createParkingLotDaoMap(capacity);
        parkingLotDao.generateParkingLot();

        String expectedResult = String.format(MessageConstant.PARKING_SUCCESS, expectedAllocatedSlot);
        String actualResult = parkingLotDao.park(carOne);

        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void park_should_notAble_toParking_a_car_when_there_noSlot() {
        ParkingLotDao parkingLotDao = ParkingLotDaoMapImpl.createParkingLotDaoMap(0);
        parkingLotDao.generateParkingLot();

        String expectedResult = MessageConstant.PARKING_LOT_FULL;
        String actualResult = parkingLotDao.park(carOne);

        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void leave_should_return_licencePlate_and_slotNumber_and_calculatedFee_when_car_isExist(){
        Integer duration = 2;
        Integer expectedSLotNumber = 1;
        BigDecimal expectedFee = new BigDecimal(2000);

        ParkingLotDao parkingLotDaoMap = ParkingLotDaoMapImpl.createParkingLotDaoMap(capacity);
        parkingLotDaoMap.generateParkingLot();
        parkingLotDaoMap.park(carOne);
        String expectedResult = String.format(MessageConstant.LEAVE_SUCCESS, carOne.getLicensePlate(), expectedSLotNumber, expectedFee);
        String actualResult = parkingLotDaoMap.remove(carOne, duration);

        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void leave_should_return_notFoundMessage_when_car_isNotExist_at_parkingLot(){
        Integer duration = 2;

        ParkingLotDao parkingLotDaoMap = ParkingLotDaoMapImpl.createParkingLotDaoMap(capacity);
        parkingLotDaoMap.generateParkingLot();

        String expectedResult = String.format(MessageConstant.CAR_NOT_FOUND, carOne.getLicensePlate());
        String actualResult = parkingLotDaoMap.remove(carOne, duration);

        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void status_should_return_statusHeaderMessage_when_no_cars_parking(){
        Integer capacity = 2;
        ParkingLotDaoMapImpl parkingLotDaoMapImpl = ParkingLotDaoMapImpl.createParkingLotDaoMap(capacity);
        parkingLotDaoMapImpl.generateParkingLot();

        String expectedResult = MessageConstant.PRINT_STATUS_HEADER;
        String actualResult = parkingLotDaoMapImpl.printStatus();

        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void status_should_return_2_cars_on_statusBodyMessage_when_2_cars_is_parking(){
        Integer capacity = 2;

        ParkingLotDaoMapImpl parkingLotDaoMapImpl = ParkingLotDaoMapImpl.createParkingLotDaoMap(capacity);
        parkingLotDaoMapImpl.generateParkingLot();
        parkingLotDaoMapImpl.park(carOne);
        parkingLotDaoMapImpl.park(carTwo);

        String expectedResult = MessageConstant.PRINT_STATUS_HEADER +
                String.format(MessageConstant.PRINT_STATUS_BODY, 1, carOne.getLicensePlate()) +
                String.format(MessageConstant.PRINT_STATUS_BODY, 2, carTwo.getLicensePlate());
        String actualResult = parkingLotDaoMapImpl.printStatus();

        assertEquals(expectedResult, actualResult);
    }
}