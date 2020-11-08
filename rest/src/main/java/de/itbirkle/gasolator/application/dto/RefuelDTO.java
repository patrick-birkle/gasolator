package de.itbirkle.gasolator.application.dto;

import lombok.Data;
import lombok.experimental.Accessors;

import java.time.ZonedDateTime;

@Data
@Accessors(chain = true)
public class RefuelDTO {

    private long id;
    private long carId;
    private long carKilometers;
    private String gasStation;
    private String gasType;
    private double liters;
    private double price;
    private ZonedDateTime timestamp;

}
