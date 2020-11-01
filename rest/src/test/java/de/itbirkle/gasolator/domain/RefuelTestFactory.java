package de.itbirkle.gasolator.domain;

import de.itbirkle.gasolator.utils.domain.refuel.RefuelBuilder;

import java.time.ZonedDateTime;

public class RefuelTestFactory {

    private static final long CAR_KILOMETERS = 1337;
    private static final String GAS_STATION = "Shell";
    private static final String GAS_TYPE = "Octane";
    private static final double LITERS = 42.12;
    private static final double PRICE = 50.99;
    private static final ZonedDateTime TIMESTAMP = ZonedDateTime.now();

    public static RefuelBuilder createBuilder(Car car) {
        return RefuelBuilder.aRefuel()
                .car(car)
                .carKilometers(CAR_KILOMETERS)
                .gasStation(GAS_STATION)
                .gasType(GAS_TYPE)
                .liters(LITERS)
                .price(PRICE)
                .timestamp(TIMESTAMP);
    }

    public static Refuel create(Car car) {
        return createBuilder(car).build();
    }

}
