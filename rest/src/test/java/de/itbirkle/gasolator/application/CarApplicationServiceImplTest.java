package de.itbirkle.gasolator.application;

import de.itbirkle.gasolator.application.dto.CarDTO;
import de.itbirkle.gasolator.domain.Car;
import de.itbirkle.gasolator.domain.CarService;
import de.itbirkle.gasolator.domain.CarTestFactory;
import de.itbirkle.gasolator.domain.RefuelTestFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Collections;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class CarApplicationServiceImplTest {

    @InjectMocks
    private CarApplicationServiceImpl underTest;

    @Mock
    private CarService carService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void saveCar() {
        CarDTO carDTO = new CarDTO().setName(CarTestFactory.NAME);
        underTest.saveCar(carDTO);
        verify(carService).saveCar(any(Car.class));
    }

    @Test
    void findCarById() {
        Car car = CarTestFactory.create();
        car.setId(1);
        car.setRefuels(Collections.singletonList(RefuelTestFactory.create(car)));
        assertEquals(1, car.getRefuels().size());

        when(carService.findCarById(eq((long) 1))).thenReturn(car);
        CarDTO carDTO = underTest.findCarById(1, false);
        assertEquals(car.getId(), carDTO.getId());
        assertEquals(car.getDescription(), carDTO.getDescription());
        assertEquals(car.getKilometers(), carDTO.getKilometers());
        assertEquals(car.getColor(), carDTO.getColor());
        assertEquals(car.getBrand(), carDTO.getBrand());
        assertEquals(car.getModel(), carDTO.getModel());
        assertNull(carDTO.getRefuels());

        when(carService.findCarById(eq((long) 2))).thenReturn(car);
        CarDTO carDTOWithRefuels = underTest.findCarById(2, true);
        assertEquals(car.getId(), carDTOWithRefuels.getId());
        assertEquals(car.getDescription(), carDTOWithRefuels.getDescription());
        assertEquals(car.getKilometers(), carDTOWithRefuels.getKilometers());
        assertEquals(car.getColor(), carDTOWithRefuels.getColor());
        assertEquals(car.getBrand(), carDTOWithRefuels.getBrand());
        assertEquals(car.getModel(), carDTOWithRefuels.getModel());
        assertEquals(1, carDTOWithRefuels.getRefuels().size());
    }

    @Test
    void updateCar() {
        final int id = 1337;
        Car car = CarTestFactory.create();
        car.setId(id);

        CarDTO carDTO = new CarDTO().setId(id);

        when(carService.findCarById(id)).thenReturn(car);
        underTest.updateCar(carDTO);
        verify(carService).updateCar(car);
    }

    @Test
    void cannotUpdateCar() {
        assertThrows(IllegalArgumentException.class, () -> underTest.updateCar(new CarDTO()));
    }

}