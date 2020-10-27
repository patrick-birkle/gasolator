package de.itbirkle.gasolator.domain;

import de.itbirkle.gasolator.exception.DataNotFoundException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class CarServiceTest {

    @InjectMocks
    private CarService underTest;

    @Mock
    private CarRepository carRepository;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void saveCar() {
        Car car = CarTestFactory.create();
        underTest.saveCar(car);
        verify(carRepository).save(car);
    }

    @Test
    void findCarById() {
        Car car = CarTestFactory.create();
        car.setId(1);

        when(carRepository.findById(eq(car.getId()))).thenReturn(Optional.of(car));
        Car carCreated = underTest.findCarById(car.getId());

        assertEquals(car, carCreated);
    }

    @Test
    void cannotFindCarById() {
        when(carRepository.findById(anyLong())).thenReturn(Optional.empty());
        assertThrows(DataNotFoundException.class, () -> underTest.findCarById(-1));
    }

    @Test
    void updateCar() {
        Car car = CarTestFactory.create();
        underTest.updateCar(car);
        verify(carRepository).save(car);
    }
}