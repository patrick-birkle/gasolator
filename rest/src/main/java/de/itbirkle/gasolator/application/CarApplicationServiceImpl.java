package de.itbirkle.gasolator.application;

import de.itbirkle.gasolator.application.dto.CarDTO;
import de.itbirkle.gasolator.domain.Car;
import de.itbirkle.gasolator.domain.CarService;
import de.itbirkle.gasolator.utils.Reject;
import de.itbirkle.gasolator.utils.domain.car.CarMapper;
import de.itbirkle.gasolator.utils.domain.car.CarUpdater;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CarApplicationServiceImpl implements CarApplicationService {

    private final CarService carService;

    @Autowired
    public CarApplicationServiceImpl(CarService carService) {
        this.carService = carService;
    }

    @Override
    public void saveCar(CarDTO carDTO) {
        Car car = CarMapper.toEntity(carDTO);
        carService.saveCar(car);
    }

    @Override
    public CarDTO findCarById(long id, boolean refuels) {
        Car car = carService.findCarById(id);
        return refuels ? CarMapper.toDTOWithRefuels(car) : CarMapper.toDTO(car);
    }

    @Override
    public void updateCar(CarDTO carDTO) {
        Reject.ifLessOrEqualZero(carDTO.getId(), "car dto id is mandatory");
        Car car = carService.findCarById(carDTO.getId());
        CarUpdater.update(car, carDTO);
        carService.updateCar(car);
    }

}
