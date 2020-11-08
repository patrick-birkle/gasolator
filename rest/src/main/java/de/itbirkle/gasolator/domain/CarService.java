package de.itbirkle.gasolator.domain;

import de.itbirkle.gasolator.exception.DataNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CarService {

    private final CarRepository carRepository;

    @Autowired
    public CarService(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    public Car findCarById(final long id) {
        return carRepository.findById(id)
                .orElseThrow(() -> new DataNotFoundException("Car could not be found"));
    }

    public void saveCar(final Car car) {
        carRepository.save(car);
    }

    public void updateCar(final Car car) {
        saveCar(car);
    }

}
