package dev.whydn.dao;

import dev.whydn.constants.MessageConstant;
import models.Car;

import java.util.HashMap;
import java.util.Map;

public class ParkingLotDaoMapImpl implements ParkingLotDao {
    private Integer capacity;
    private Map<Integer, Car> parkingLots = new HashMap<>();

    private ParkingLotDaoMapImpl(Integer capacity) {
        this.capacity = capacity;
    }

    public static ParkingLotDaoMapImpl createParkingLotDaoMap(Integer capacity) {
        return new ParkingLotDaoMapImpl(capacity);
    }

    @Override
    public String generateParkingLot() {
        for (int i = 1; i <= this.capacity; i++) {
           this.parkingLots.put(i, null);
        }
        return String.format(MessageConstant.CREATE_PARKING_LOT_SUCCESS, this.capacity);
    }

    @Override
    public String park(Car car) {
        for (int i = 1; i <= this.capacity; i++) {
            if (parkingLots.get(i) == null) {
                parkingLots.put(i, car);
                return String.format(MessageConstant.PARKING_SUCCESS, i);
            }
        }
        return MessageConstant.PARKING_LOT_FULL;
    }
}
