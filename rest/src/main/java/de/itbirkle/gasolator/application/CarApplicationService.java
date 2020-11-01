package de.itbirkle.gasolator.application;

import de.itbirkle.gasolator.application.dto.CarDTO;

public interface CarApplicationService {

    void saveCar(CarDTO carDTO);
    CarDTO findCarById(long id, boolean refuels);
    void updateCar(CarDTO carDTO);

}
