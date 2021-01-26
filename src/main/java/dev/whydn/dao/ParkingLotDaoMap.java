package dev.whydn.dao;

import dev.whydn.constants.MessageConstant;
import models.Car;

import java.util.HashMap;
import java.util.Map;

public class ParkingLotDaoMap implements ParkingLotDao {
    private Integer capacity;
    private Map<Integer, Car> parkingLots = new HashMap<>();

    private ParkingLotDaoMap(Integer capacity) {
        this.capacity = capacity;
    }

    public static ParkingLotDaoMap createParkingLotDaoMap(Integer capacity) {
        return new ParkingLotDaoMap(capacity);
    }

    @Override
    public String generateParkingLot() {
        for (int i = 1; i <= capacity; i++) {
           this.parkingLots.put(i, null);
        }
        return String.format(MessageConstant.CREATE_PARKING_LOT_SUCCESS, this.capacity);
    }
}
