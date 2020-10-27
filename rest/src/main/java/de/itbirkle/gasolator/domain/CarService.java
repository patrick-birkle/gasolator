package de.itbirkle.gasolator.domain;

import de.itbirkle.gasolator.exception.DataNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CarService {

    private final CarRepository carRepository;

    @Autowired
    public CarService(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    public void saveCar(final Car car) {
        carRepository.save(car);
    }

    public Car findCarById(final long id) {
        Optional<Car> optCar = carRepository.findById(id);
        if (optCar.isEmpty()) {
            throw new DataNotFoundException("Car could not be found");
        }
        return optCar.get();
    }

    public void updateCar(final Car car) {
        saveCar(car);
    }

}
