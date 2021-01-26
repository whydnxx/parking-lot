package dev.whydn.utils;

import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

public class ParkingFeeCalculatorTest {

    @Test
    public void createParkingFeeCalculator_should_return_ParkingFeeCalculator_class() {
        Class expected = ParkingFeeCalculator.class;
        Class actual = ParkingFeeCalculator.createParkingFeeCalculator().getClass();

        assertEquals(expected, actual);
    }

    @Test
    public void calculateFee_return_fee_2000_with_givenDuration_2() {
        int expectedFee = 2000;
        Integer givenDuration = 2;

        ParkingFeeCalculator parkingFeeCalculator = ParkingFeeCalculator.createParkingFeeCalculator();

        BigDecimal expectedResult = new BigDecimal(expectedFee);
        BigDecimal actualResult = parkingFeeCalculator.calculateFee(givenDuration);

        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void calculateFee_return_fee_8000_with_givenDuration_4() {
        int expectedFee = 8000;
        Integer givenDuration = 4;

        ParkingFeeCalculator parkingFeeCalculator = ParkingFeeCalculator.createParkingFeeCalculator();

        BigDecimal expectedResult = new BigDecimal(expectedFee);
        BigDecimal actualResult = parkingFeeCalculator.calculateFee(givenDuration);

        assertEquals(expectedResult, actualResult);
    }
}