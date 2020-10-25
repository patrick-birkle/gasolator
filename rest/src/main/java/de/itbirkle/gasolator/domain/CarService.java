package de.itbirkle.gasolator.domain;

import de.itbirkle.gasolator.application.CarDTO;
import de.itbirkle.gasolator.utils.domain.CarMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CarService {

    private final CarRepository carRepository;

    @Autowired
    public CarService(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    public void saveCar(final CarDTO carDTO) {
        Car car = CarMapper.toEntity(carDTO);
        carRepository.save(car);
    }

    public CarDTO getCar(final long id) {
        Car car = carRepository.getOne(id);
        return CarMapper.toDTO(car);
    }

}
