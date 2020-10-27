package de.itbirkle.gasolator.domain;

import de.itbirkle.gasolator.utils.domain.CarBuilder;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

class CarTest {

    private static final String NAME = "Mercedes A-Class";
    private static final String DESCRIPTION = "";
    private static final long KILOMETERS = 1337;
    private static final String COLOR = "white";
    private static final String BRAND = "Mercedes";
    private static final String MODEL = "A220";

    @Test
    public void canBuildCar() {
        Car car = CarBuilder.aCar()
                .name(NAME)
                .description(DESCRIPTION)
                .kilometers(KILOMETERS)
                .color(COLOR)
                .brand(BRAND)
                .model(MODEL)
                .build();

        assertEquals(0, car.getId());
        assertEquals(NAME, car.getName());
        assertEquals(DESCRIPTION, car.getDescription());
        assertEquals(KILOMETERS, car.getKilometers());
        assertEquals(COLOR, car.getColor());
        assertEquals(BRAND, car.getBrand());
        assertEquals(MODEL, car.getModel());
        assertNotNull(car.getRefuels());
        assertEquals(0, car.getRefuels().size());
    }

    @Test
    public void cannotBuildCarNoName() {
        CarBuilder carBuilder = CarBuilder.aCar()
                .description(DESCRIPTION)
                .kilometers(KILOMETERS)
                .color(COLOR)
                .brand(BRAND)
                .model(MODEL);

        assertThrows(IllegalArgumentException.class, carBuilder::build);
    }

}