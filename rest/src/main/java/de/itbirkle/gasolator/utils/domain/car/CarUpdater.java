package de.itbirkle.gasolator.utils.domain.car;

import de.itbirkle.gasolator.application.dto.CarDTO;
import de.itbirkle.gasolator.domain.Car;
import de.itbirkle.gasolator.utils.Reject;
import de.itbirkle.gasolator.utils.StringUtils;

public class CarUpdater {

    public static void update(Car car, CarDTO carDTO) {
        Reject.ifNull(car, "car is mandatory");
        Reject.ifNull(carDTO, "car dto is mandatory");

        if (StringUtils.isNotBlank(carDTO.getName())) {
            car.setName(carDTO.getName());
        }

        if (StringUtils.isNotBlank(carDTO.getDescription())) {
            car.setDescription(carDTO.getDescription());
        }

        if (StringUtils.isNotBlank(carDTO.getColor())) {
            car.setColor(carDTO.getColor());
        }

        if (StringUtils.isNotBlank(carDTO.getBrand())) {
            car.setBrand(carDTO.getBrand());
        }

        if (StringUtils.isNotBlank(carDTO.getModel())) {
            car.setModel(carDTO.getModel());
        }
    }

}
