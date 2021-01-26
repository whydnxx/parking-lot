package dev.whydn.dao;

import dev.whydn.models.Car;

public interface ParkingLotDao {
    String generateParkingLot();
    String park(Car car);
    String remove(Car car, Integer duration);
    String printStatus();
}
