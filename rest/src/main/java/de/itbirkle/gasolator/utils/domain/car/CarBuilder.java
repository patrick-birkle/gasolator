package de.itbirkle.gasolator.utils.domain.car;

import de.itbirkle.gasolator.domain.Car;
import de.itbirkle.gasolator.utils.Reject;

import java.util.ArrayList;

public final class CarBuilder {
    private String name;
    private String description;
    private long kilometers;
    private String color;
    private String brand;
    private String model;

    private CarBuilder() {
    }

    public static CarBuilder aCar() {
        return new CarBuilder();
    }

    public CarBuilder name(String name) {
        this.name = name;
        return this;
    }

    public CarBuilder description(String description) {
        this.description = description;
        return this;
    }

    public CarBuilder kilometers(long kilometers) {
        this.kilometers = kilometers;
        return this;
    }

    public CarBuilder color(String color) {
        this.color = color;
        return this;
    }

    public CarBuilder brand(String brand) {
        this.brand = brand;
        return this;
    }

    public CarBuilder model(String model) {
        this.model = model;
        return this;
    }

    public Car build() {
        Reject.ifBlank(name, "name is mandatory");

        Car car = new Car();
        car.setName(name);
        car.setDescription(description);
        car.setKilometers(kilometers);
        car.setColor(color);
        car.setBrand(brand);
        car.setModel(model);
        car.setRefuels(new ArrayList<>());
        return car;
    }
}
