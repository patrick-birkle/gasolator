package de.itbirkle.gasolator.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.verify;

class RefuelServiceTest {

    @InjectMocks
    private RefuelService underTest;

    @Mock
    private RefuelRepository refuelRepository;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void saveRefuel() {
        Car car = CarTestFactory.create();
        Refuel refuel = RefuelTestFactory.create(car);
        underTest.saveRefuel(refuel);
        verify(refuelRepository).save(refuel);
    }

    @Test
    void updateRefuel() {
        Car car = CarTestFactory.create();
        Refuel refuel = RefuelTestFactory.create(car);
        underTest.updateRefuel(refuel);
        verify(refuelRepository).save(refuel);
    }
}