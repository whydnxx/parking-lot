package dev.whydn.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Objects;

@NoArgsConstructor
@Getter @Setter
public class Car {
    private String licensePlate;
    private CarColor carColor;

    public static Car createCar(String licensePlate) {
        return new Car(licensePlate);
    }

    public Car(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return Objects.equals(licensePlate, car.licensePlate);
    }
}
