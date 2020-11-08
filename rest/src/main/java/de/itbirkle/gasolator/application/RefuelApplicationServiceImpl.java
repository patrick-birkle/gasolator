package de.itbirkle.gasolator.application;

import de.itbirkle.gasolator.application.dto.RefuelDTO;
import de.itbirkle.gasolator.domain.Car;
import de.itbirkle.gasolator.domain.CarService;
import de.itbirkle.gasolator.domain.Refuel;
import de.itbirkle.gasolator.domain.RefuelService;
import de.itbirkle.gasolator.utils.Reject;
import de.itbirkle.gasolator.utils.domain.refuel.RefuelMapper;
import de.itbirkle.gasolator.utils.domain.refuel.RefuelUpdater;
import org.springframework.beans.factory.annotation.Autowired;

public class RefuelApplicationServiceImpl implements RefuelApplicationService {

    @Autowired
    private CarService carService;

    @Autowired
    private RefuelService refuelService;

    @Override
    public void saveRefuel(RefuelDTO refuelDTO) {
        Reject.ifLessOrEqualZero(refuelDTO.getCarId(), "car id is mandatory");
        Car car = carService.findCarById(refuelDTO.getCarId());
        Refuel refuel = RefuelMapper.toEntity(car, refuelDTO);
        refuelService.saveRefuel(refuel);
    }

    @Override
    public void updateRefuel(RefuelDTO refuelDTO) {
        Reject.ifLessOrEqualZero(refuelDTO.getId(), "refuel id is mandatory");
        Refuel refuel = refuelService.findRefuelById(refuelDTO.getId());
        RefuelUpdater.update(refuel, refuelDTO);
        refuelService.updateRefuel(refuel);
    }
}
