package de.itbirkle.gasolator.utils.domain.car;

import de.itbirkle.gasolator.application.dto.CarDTO;
import de.itbirkle.gasolator.domain.Car;
import de.itbirkle.gasolator.utils.domain.refuel.RefuelMapper;

public class CarMapper {

    public static CarDTO toDTOWithRefuels(Car car) {
        return toDTO(car).setRefuels(RefuelMapper.toDTO(car.getRefuels()));
    }

    public static CarDTO toDTO(Car car) {
        return new CarDTO()
                .setId(car.getId())
                .setName(car.getName())
                .setDescription(car.getDescription())
                .setKilometers(car.getKilometers())
                .setColor(car.getColor())
                .setBrand(car.getBrand())
                .setModel(car.getModel());
    }

    public static Car toEntity(CarDTO carDTO) {
        return CarBuilder.aCar()
                .name(carDTO.getName())
                .description(carDTO.getDescription())
                .kilometers(carDTO.getKilometers())
                .color(carDTO.getColor())
                .brand(carDTO.getBrand())
                .model(carDTO.getModel())
                .build();
    }

}
