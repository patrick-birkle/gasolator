package de.itbirkle.gasolator.utils.domain;

import de.itbirkle.gasolator.application.RefuelDTO;
import de.itbirkle.gasolator.domain.Refuel;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class RefuelMapper {

    public static RefuelDTO toDTO(Refuel refuel) {
        return new RefuelDTO()
                .setCarKilometers(refuel.getCarKilometers())
                .setGasStation(refuel.getGasStation())
                .setGasType(refuel.getGasType())
                .setLiters(refuel.getLiters())
                .setPrice(refuel.getPrice())
                .setTimestamp(refuel.getTimestamp());
    }

    public static List<RefuelDTO> toDTO(List<Refuel> refuels) {
        if (refuels == null) {
            return Collections.emptyList();
        }

        return refuels.stream()
                .map(RefuelMapper::toDTO)
                .collect(Collectors.toList());
    }

}
