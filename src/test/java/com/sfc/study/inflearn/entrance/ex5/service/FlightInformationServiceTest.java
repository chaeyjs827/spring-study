package com.sfc.study.inflearn.entrance.ex5.service;

import com.sfc.study.inflearn.entrance.ex5.repository.FlightInformationRepository;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FlightInformationServiceTest {

    private final FlightInformationService flightInformationService;

    public FlightInformationServiceTest(
            FlightInformationService flightInformationService
    ) {
        this.flightInformationService = flightInformationService;
    }

    @Test
    void save() {
        flightInformationService.save();
    }

    @Test
    void getFlightInformationList() {
        flightInformationService.getFlightInformationList();
    }

    @Test
    void getFlight() {
        flightInformationService.getFlight();
    }
}