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
    void findRefuelById() {
        Refuel refuel = RefuelTestFactory.create(CarTestFactory.create());
        when(refuelRepository.findById(eq(refuel.getId()))).thenReturn(Optional.of(refuel));

        Refuel result = underTest.findRefuelById(refuel.getId());

        assertEquals(refuel, result);
    }

    @Test
    void cannotFindRefuelById() {
        when(refuelRepository.findById(anyLong())).thenReturn(Optional.empty());
        assertThrows(DataNotFoundException.class, () -> underTest.findRefuelById(-1));
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