package de.itbirkle.gasolator.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RefuelService {

    private RefuelRepository refuelRepository;

    @Autowired
    public RefuelService(RefuelRepository refuelRepository) {
        this.refuelRepository = refuelRepository;
    }

}
