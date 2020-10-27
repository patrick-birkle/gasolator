package de.itbirkle.gasolator.utils.domain;

import de.itbirkle.gasolator.application.CarDTO;
import de.itbirkle.gasolator.domain.Car;
import de.itbirkle.gasolator.domain.CarTestFactory;
import de.itbirkle.gasolator.domain.RefuelTestFactory;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.*;

class CarMapperTest {

    @Test
    void toDTO() {

        Car car = CarTestFactory.create();
        CarDTO carDTO = CarMapper.toDTO(car);

        assertEquals(CarTestFactory.NAME, carDTO.getName());
        assertEquals(CarTestFactory.DESCRIPTION, carDTO.getDescription());
        assertEquals(CarTestFactory.KILOMETERS, carDTO.getKilometers());
        assertEquals(CarTestFactory.COLOR, carDTO.getColor());
        assertEquals(CarTestFactory.BRAND, carDTO.getBrand());
        assertEquals(CarTestFactory.MODEL, carDTO.getModel());
    }

    @Test
    void toDTOWithRefuels() {
        Car car = CarTestFactory.create();
        car.setRefuels(Collections.singletonList(RefuelTestFactory.create(car)));

        CarDTO carDTO = CarMapper.toDTOWithRefuels(car);

        assertEquals(CarTestFactory.NAME, carDTO.getName());
        assertEquals(CarTestFactory.DESCRIPTION, carDTO.getDescription());
        assertEquals(CarTestFactory.KILOMETERS, carDTO.getKilometers());
        assertEquals(CarTestFactory.COLOR, carDTO.getColor());
        assertEquals(CarTestFactory.BRAND, carDTO.getBrand());
        assertEquals(CarTestFactory.MODEL, carDTO.getModel());
        assertEquals(1, carDTO.getRefuels().size());
    }

    @Test
    void toDTOWithRefuelsNull() {
        Car car = CarTestFactory.create();
        car.setRefuels(null);

        CarDTO carDTO = CarMapper.toDTOWithRefuels(car);

        assertEquals(CarTestFactory.NAME, carDTO.getName());
        assertEquals(CarTestFactory.DESCRIPTION, carDTO.getDescription());
        assertEquals(CarTestFactory.KILOMETERS, carDTO.getKilometers());
        assertEquals(CarTestFactory.COLOR, carDTO.getColor());
        assertEquals(CarTestFactory.BRAND, carDTO.getBrand());
        assertEquals(CarTestFactory.MODEL, carDTO.getModel());
        assertTrue(carDTO.getRefuels().isEmpty());
    }

    @Test
    void toEntity() {

        CarDTO carDTO = new CarDTO()
                .setName(CarTestFactory.NAME)
                .setDescription(CarTestFactory.DESCRIPTION)
                .setKilometers(CarTestFactory.KILOMETERS)
                .setColor(CarTestFactory.COLOR)
                .setBrand(CarTestFactory.BRAND)
                .setModel(CarTestFactory.MODEL);

        Car car = CarMapper.toEntity(carDTO);

        assertEquals(CarTestFactory.NAME, car.getName());
        assertEquals(CarTestFactory.DESCRIPTION, car.getDescription());
        assertEquals(CarTestFactory.KILOMETERS, car.getKilometers());
        assertEquals(CarTestFactory.COLOR, car.getColor());
        assertEquals(CarTestFactory.BRAND, car.getBrand());
        assertEquals(CarTestFactory.MODEL, car.getModel());

    }
}