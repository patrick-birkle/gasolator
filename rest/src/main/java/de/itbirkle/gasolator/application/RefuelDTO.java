package de.itbirkle.gasolator.application;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.time.ZonedDateTime;

@Getter
@Setter
@NoArgsConstructor
@Accessors(chain = true)
public class RefuelDTO {

    private long carKilometers;
    private String gasStation;
    private String gasType;
    private double liters;
    private double price;
    private ZonedDateTime timestamp;

}
