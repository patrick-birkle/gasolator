package de.itbirkle.gasolator.domain;

import de.itbirkle.gasolator.utils.domain.RefuelBuilder;
import org.junit.jupiter.api.Test;

import java.time.ZonedDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

class RefuelTest {

    private static final Car CAR = CarTestFactory.create();
    private static final long CAR_KILOMETERS = 1337;
    private static final String GAS_STATION = "Shell";
    private static final String GAS_TYPE = "Octane";
    private static final double LITERS = 42.12;
    private static final double PRICE = 50.99;
    private static final ZonedDateTime TIMESTAMP = ZonedDateTime.now();


    @Test
    public void canBuildRefuel() {

        Refuel refuel = RefuelBuilder.aRefuel()
                .car(CAR)
                .carKilometers(CAR_KILOMETERS)
                .gasStation(GAS_STATION)
                .gasType(GAS_TYPE)
                .liters(LITERS)
                .price(PRICE)
                .timestamp(TIMESTAMP)
                .build();

        assertEquals(0, refuel.getId());
        assertNotNull(refuel.getCar());
        assertEquals(CAR_KILOMETERS, refuel.getCarKilometers());
        assertEquals(GAS_STATION, refuel.getGasStation());
        assertEquals(GAS_TYPE, refuel.getGasType());
        assertEquals(LITERS, refuel.getLiters());
        assertEquals(PRICE, refuel.getPrice());
        assertEquals(TIMESTAMP, refuel.getTimestamp());

    }

    @Test
    public void cannotBuildRefuel() {

        RefuelBuilder refuelBuilderNoCar = RefuelBuilder.aRefuel()
                .carKilometers(CAR_KILOMETERS)
                .gasStation(GAS_STATION)
                .gasType(GAS_TYPE)
                .liters(LITERS)
                .price(PRICE)
                .timestamp(TIMESTAMP);

        RefuelBuilder refuelBuilderCarKilometers = RefuelBuilder.aRefuel()
                .car(CAR)
                .carKilometers(0)
                .gasStation(GAS_STATION)
                .gasType(GAS_TYPE)
                .liters(LITERS)
                .price(PRICE)
                .timestamp(TIMESTAMP);

        RefuelBuilder refuelBuilderLiters = RefuelBuilder.aRefuel()
                .car(CAR)
                .carKilometers(CAR_KILOMETERS)
                .gasStation(GAS_STATION)
                .gasType(GAS_TYPE)
                .liters(0.0)
                .price(PRICE)
                .timestamp(TIMESTAMP);

        RefuelBuilder refuelBuilderPrice = RefuelBuilder.aRefuel()
                .car(CAR)
                .carKilometers(CAR_KILOMETERS)
                .gasStation(GAS_STATION)
                .gasType(GAS_TYPE)
                .liters(LITERS)
                .price(0.0)
                .timestamp(TIMESTAMP);


        assertThrows(IllegalArgumentException.class, refuelBuilderNoCar::build);
        assertThrows(IllegalArgumentException.class, refuelBuilderCarKilometers::build);
        assertThrows(IllegalArgumentException.class, refuelBuilderLiters::build);
        assertThrows(IllegalArgumentException.class, refuelBuilderPrice::build);
    }

}