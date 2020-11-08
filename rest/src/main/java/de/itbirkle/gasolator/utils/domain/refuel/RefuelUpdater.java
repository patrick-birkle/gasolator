package de.itbirkle.gasolator.utils.domain.refuel;

import de.itbirkle.gasolator.application.dto.RefuelDTO;
import de.itbirkle.gasolator.domain.Refuel;
import de.itbirkle.gasolator.utils.Reject;
import de.itbirkle.gasolator.utils.StringUtils;

public class RefuelUpdater {

    public static void update(Refuel refuel, RefuelDTO refuelDTO) {
        Reject.ifNull(refuel, "refuel is mandatory");
        Reject.ifNull(refuelDTO, "refuel dto is mandatory");

        if (refuelDTO.getCarKilometers() > 0) {
            refuel.setCarKilometers(refuelDTO.getCarKilometers());
        }

        if (StringUtils.isNotBlank(refuelDTO.getGasStation())) {
            refuel.setGasStation(refuelDTO.getGasStation());
        }

        if (StringUtils.isNotBlank(refuelDTO.getGasType())) {
            refuel.setGasType(refuelDTO.getGasType());
        }

        if (refuelDTO.getLiters() > 0) {
            refuel.setLiters(refuelDTO.getLiters());
        }

        if (refuelDTO.getPrice() > 0) {
            refuel.setPrice(refuelDTO.getPrice());
        }
    }

}
