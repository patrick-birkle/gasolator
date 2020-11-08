package de.itbirkle.gasolator.domain;

import de.itbirkle.gasolator.exception.DataNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RefuelService {

    private final RefuelRepository refuelRepository;

    @Autowired
    public RefuelService(RefuelRepository refuelRepository) {
        this.refuelRepository = refuelRepository;
    }

    public Refuel findRefuelById(long id) {
        return refuelRepository.findById(id)
                .orElseThrow(() -> new DataNotFoundException("Refuel could not be found"));
    }

    public void saveRefuel(Refuel refuel) {
        refuelRepository.save(refuel);
    }

    public void updateRefuel(Refuel refuel) {
        saveRefuel(refuel);
    }
}
