package de.itbirkle.gasolator.application;

import de.itbirkle.gasolator.application.dto.RefuelDTO;
import de.itbirkle.gasolator.domain.Car;
import de.itbirkle.gasolator.domain.CarService;
import de.itbirkle.gasolator.domain.CarTestFactory;
import de.itbirkle.gasolator.domain.Refuel;
import de.itbirkle.gasolator.domain.RefuelRepository;
import de.itbirkle.gasolator.domain.RefuelService;
import de.itbirkle.gasolator.domain.RefuelTestFactory;
import de.itbirkle.gasolator.exception.DataNotFoundException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class RefuelApplicationServiceImplTest {

    @InjectMocks
    private RefuelApplicationServiceImpl underTest;

    @Mock
    private CarService carService;

    @Mock
    private RefuelService refuelService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void saveRefuel() {

        Car car = CarTestFactory.create()
                .setId(1);
        when(carService.findCarById(eq(car.getId()))).thenReturn(car);

        RefuelDTO refuelDTO = new RefuelDTO()
                .setCarId(car.getId())
                .setCarKilometers(1337)
                .setLiters(54.26)
                .setPrice(70.12);

        underTest.saveRefuel(refuelDTO);
        verify(refuelService).saveRefuel(any(Refuel.class));
    }

    @Test
    void cannotSaveRefuel() {
        assertThrows(IllegalArgumentException.class, () -> underTest.saveRefuel(new RefuelDTO()));
    }

    @Test
    void updateRefuel() {
        Car car = CarTestFactory.create()
                .setId(1);
        Refuel refuel = RefuelTestFactory.create(car)
                .setId(5);
        when(refuelService.findRefuelById(eq(refuel.getId()))).thenReturn(refuel);

        RefuelDTO refuelDTO = new RefuelDTO()
                .setId(refuel.getId())
                .setCarKilometers(car.getId())
                .setLiters(54.26)
                .setPrice(70.12);

        underTest.updateRefuel(refuelDTO);

        verify(refuelService).updateRefuel(any(Refuel.class));
    }

    @Test
    void cannotUpdateRefuel() {
        assertThrows(IllegalArgumentException.class, () -> underTest.updateRefuel(new RefuelDTO()));
    }
}