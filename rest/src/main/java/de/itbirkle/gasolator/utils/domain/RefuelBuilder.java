package de.itbirkle.gasolator.utils.domain;

import de.itbirkle.gasolator.domain.Car;
import de.itbirkle.gasolator.domain.Refuel;
import de.itbirkle.gasolator.utils.Reject;

import java.time.ZonedDateTime;

public final class RefuelBuilder {
    private Car car;
    private long carKilometers;
    private String gasStation;
    private String gasType;
    private double liters;
    private double price;
    private ZonedDateTime timestamp;

    private RefuelBuilder() {
    }

    public static RefuelBuilder aRefuel() {
        return new RefuelBuilder();
    }

    public RefuelBuilder car(Car car) {
        this.car = car;
        return this;
    }

    public RefuelBuilder carKilometers(long carKilometers) {
        this.carKilometers = carKilometers;
        return this;
    }

    public RefuelBuilder gasStation(String gasStation) {
        this.gasStation = gasStation;
        return this;
    }

    public RefuelBuilder gasType(String gasType) {
        this.gasType = gasType;
        return this;
    }

    public RefuelBuilder liters(double liters) {
        this.liters = liters;
        return this;
    }

    public RefuelBuilder price(double price) {
        this.price = price;
        return this;
    }

    public RefuelBuilder timestamp(ZonedDateTime timestamp) {
        this.timestamp = timestamp;
        return this;
    }

    public Refuel build() {
        Reject.ifNull(car, "car");
        Reject.ifLessOrEqualZero(carKilometers, "car kilometers");
        Reject.ifLessOrEqualZero(liters, "liters");
        Reject.ifLessOrEqualZero(price, "price");

        Refuel refuel = new Refuel();
        refuel.setCar(car);
        refuel.setCarKilometers(carKilometers);
        refuel.setGasStation(gasStation);
        refuel.setGasType(gasType);
        refuel.setLiters(liters);
        refuel.setPrice(price);
        refuel.setTimestamp(timestamp);
        return refuel;
    }
}
