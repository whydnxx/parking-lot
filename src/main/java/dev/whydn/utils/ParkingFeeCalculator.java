package dev.whydn.utils;

import java.math.BigDecimal;

public class ParkingFeeCalculator {
    public static final int FIRST_HOURS = 2;
    public static final BigDecimal FIRST_HOUR_FEE = new BigDecimal(2000);
    public static final BigDecimal NEXT_HOUR_FEE = new BigDecimal(3000);

    public static ParkingFeeCalculator createParkingFeeCalculator() {
        return new ParkingFeeCalculator();
    }

    public BigDecimal calculateFee(Integer durations) {
        return durations <= FIRST_HOURS ? FIRST_HOUR_FEE : FIRST_HOUR_FEE.add((new BigDecimal(durations - FIRST_HOURS).multiply(NEXT_HOUR_FEE)));
    }
}
