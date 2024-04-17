package com.sfc.study.inflearn.entrance.ex5.service;

import com.sfc.study.inflearn.entrance.ex5.domain.FlightInformation;
import com.sfc.study.inflearn.entrance.ex5.repository.FlightInformationJdbcRepository;
import com.sfc.study.inflearn.entrance.ex5.repository.FlightInformationMemoryRepository;
import com.sfc.study.inflearn.entrance.ex5.repository.FlightInformationRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FlightInformationService {

    private FlightInformationRepository flightInformationRepository;

    public FlightInformationService(
            FlightInformationJdbcRepository flightInformationJdbcRepository
            , FlightInformationMemoryRepository flightInformationMemoryRepository
    ) {
        this.flightInformationRepository = flightInformationJdbcRepository;
//        this.flightInformationRepository = flightInformationMemoryRepository;
    }

    public void save() {
        FlightInformation flightInformation = new FlightInformation();
        flightInformation.setFlightNo("test1234");
        flightInformation.setDepartureTime("2024-04-16 00:00:00");
        flightInformation.setArrivalTime("2024-04-16 00:00:00");
        flightInformationRepository.save(flightInformation);
    }

    public List<FlightInformation> getFlightInformationList() {
        return flightInformationRepository.getFlightList();
    }

    public void getFlight() {
        flightInformationRepository.getFlight();
    }


}
