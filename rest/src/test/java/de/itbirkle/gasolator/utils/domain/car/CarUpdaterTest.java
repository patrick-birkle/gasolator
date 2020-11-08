package de.itbirkle.gasolator.utils.domain.car;

import de.itbirkle.gasolator.application.dto.CarDTO;
import de.itbirkle.gasolator.domain.Car;
import de.itbirkle.gasolator.domain.CarTestFactory;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CarUpdaterTest {

    private final String name = "TEST_NAME";
    private final String description = "TEST_DESCRIPTION";
    private final String color = "TEST_COLOR";
    private final String brand = "TEST_BRAND";
    private final String model = "TEST_MODEL";

    @Test
    void update() {
        Car car = CarTestFactory.create();
        car.setId(1);

        CarDTO carDTO = new CarDTO()
                .setId(1)
                .setName(name)
                .setDescription(description)
                .setColor(color)
                .setBrand(brand)
                .setModel(model);

        CarUpdater.update(car, carDTO);

        assertEquals(name, car.getName());
        assertEquals(description, car.getDescription());
        assertEquals(color, car.getColor());
        assertEquals(brand, car.getBrand());
        assertEquals(model, car.getModel());
    }

    @Test
    void cannotUpdate() {
        Car car = CarTestFactory.create();
        car.setId(1);

        CarDTO carDTO = new CarDTO()
                .setId(1)
                .setName(name)
                .setDescription(description)
                .setColor(color)
                .setBrand(brand)
                .setModel(model);

        assertThrows(IllegalArgumentException.class, () -> CarUpdater.update(null, carDTO));
        assertThrows(IllegalArgumentException.class, () -> CarUpdater.update(car, null));
    }


}