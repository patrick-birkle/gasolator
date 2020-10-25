package de.itbirkle.gasolator.domain;

import de.itbirkle.gasolator.utils.domain.CarBuilder;

public class CarTestFactory {

    private static final String NAME = "Mercedes A-Class";
    private static final String DESCRIPTION = "";
    private static final long KILOMETERS = 1337;
    private static final String COLOR = "white";
    private static final String BRAND = "Mercedes";
    private static final String MODEL = "A220";

    public static Car createCar() {

        return CarBuilder.aCar()
                .name(NAME)
                .description(DESCRIPTION)
                .kilometers(KILOMETERS)
                .color(COLOR)
                .brand(BRAND)
                .model(MODEL)
                .build();

    }

}
