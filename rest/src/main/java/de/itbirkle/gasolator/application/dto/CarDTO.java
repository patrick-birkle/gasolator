package de.itbirkle.gasolator.application.dto;

import lombok.Data;
import lombok.experimental.Accessors;

import java.util.List;

@Data
@Accessors(chain = true)
public class CarDTO {

    private long id;
    private String name;
    private String description;
    private long kilometers;
    private String color;
    private String brand;
    private String model;
    private List<RefuelDTO> refuels;

}
