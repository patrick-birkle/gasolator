package de.itbirkle.gasolator.application;

import de.itbirkle.gasolator.application.dto.RefuelDTO;

public interface RefuelApplicationService {

    void saveRefuel(RefuelDTO refuelDTO);
    void updateRefuel(RefuelDTO refuelDTO);

}
