package com.sfc.study.inflearn.entrance.ex5.service;

import com.sfc.study.inflearn.entrance.ex5.domain.FlightInformation;
import com.sfc.study.inflearn.entrance.ex5.repository.FlightInformationJdbcRepository;
import com.sfc.study.inflearn.entrance.ex5.repository.FlightInformationJpaRepository;
import com.sfc.study.inflearn.entrance.ex5.repository.FlightInformationMemoryRepository;
import com.sfc.study.inflearn.entrance.ex5.repository.FlightInformationRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class FlightInformationService {

    private FlightInformationRepository flightInformationRepository;

    public FlightInformationService(
            FlightInformationJdbcRepository flightInformationJdbcRepository
            , FlightInformationMemoryRepository flightInformationMemoryRepository
            , FlightInformationJpaRepository flightInformationJpaRepository
    ) {
//        this.flightInformationRepository = flightInformationJdbcRepository;
//        this.flightInformationRepository = flightInformationMemoryRepository;
        this.flightInformationRepository = flightInformationJpaRepository;
    }

    public void save(FlightInformation flightInformation) {
        flightInformationRepository.save(flightInformation);
    }

    public List<FlightInformation> getFlightInformationList() {
        return flightInformationRepository.getFlightList();
    }

    public Optional<FlightInformation> getFlight(Long id) {
        return flightInformationRepository.getFlight(id);
    }

    public Optional<FlightInformation> getFlightByFlightNo(String flightNo) {
        return flightInformationRepository.getFlightByFlightNo(flightNo);
    }


}
