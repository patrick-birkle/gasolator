package de.itbirkle.gasolator.application;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
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
