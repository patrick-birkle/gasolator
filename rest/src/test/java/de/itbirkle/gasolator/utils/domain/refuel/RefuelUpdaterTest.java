package de.itbirkle.gasolator.utils.domain.refuel;

import de.itbirkle.gasolator.application.dto.RefuelDTO;
import de.itbirkle.gasolator.domain.Car;
import de.itbirkle.gasolator.domain.CarTestFactory;
import de.itbirkle.gasolator.domain.Refuel;
import de.itbirkle.gasolator.domain.RefuelTestFactory;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RefuelUpdaterTest {

    private final long carKilometers = 9999;
    private final String gasStation = "TEST_GAS_STATION";
    private final String gasType = "TEST_GAS_TYPE";
    private final double liters = 99.99;
    private final double price = 99.99;

    @Test
    void update() {
        Refuel refuel = RefuelTestFactory.create(CarTestFactory.create());
        RefuelDTO refuelDTO = new RefuelDTO()
                .setCarKilometers(carKilometers)
                .setGasStation(gasStation)
                .setGasType(gasType)
                .setLiters(liters)
                .setPrice(price);

        RefuelUpdater.update(refuel, refuelDTO);

        assertEquals(carKilometers, refuel.getCarKilometers());
        assertEquals(gasStation, refuel.getGasStation());
        assertEquals(gasType, refuel.getGasType());
        assertEquals(liters, refuel.getLiters());
        assertEquals(price, refuel.getPrice());
    }

    @Test
    void cannotUpdate() {
        Refuel refuel = RefuelTestFactory.create(CarTestFactory.create());
        RefuelDTO refuelDTO = new RefuelDTO()
                .setCarKilometers(carKilometers)
                .setGasStation(gasStation)
                .setGasType(gasType)
                .setLiters(liters)
                .setPrice(price);

        assertThrows(IllegalArgumentException.class, () -> RefuelUpdater.update(refuel, null));
        assertThrows(IllegalArgumentException.class, () -> RefuelUpdater.update(null, refuelDTO));
    }
}