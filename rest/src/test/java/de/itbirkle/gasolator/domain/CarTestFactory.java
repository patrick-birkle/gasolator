package de.itbirkle.gasolator.domain;

import de.itbirkle.gasolator.utils.domain.car.CarBuilder;

public class CarTestFactory {

    public static final long ID = 1337;
    public static final String NAME = "Mercedes A-Class";
    public static final String DESCRIPTION = "";
    public static final long KILOMETERS = 1337;
    public static final String COLOR = "white";
    public static final String BRAND = "Mercedes";
    public static final String MODEL = "A220";

    public static CarBuilder createBuilder() {
        return CarBuilder.aCar()
                .name(NAME)
                .description(DESCRIPTION)
                .kilometers(KILOMETERS)
                .color(COLOR)
                .brand(BRAND)
                .model(MODEL);
    }

    public static Car create() {
        return createBuilder().build();
    }

}
