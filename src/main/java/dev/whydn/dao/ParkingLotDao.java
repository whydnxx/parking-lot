package dev.whydn.dao;

import models.Car;

public interface ParkingLotDao {
    String generateParkingLot();
    String park(Car car);
}
