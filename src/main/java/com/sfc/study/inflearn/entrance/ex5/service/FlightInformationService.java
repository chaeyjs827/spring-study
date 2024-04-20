package com.sfc.study.inflearn.entrance.ex5.service;

import com.sfc.study.inflearn.entrance.ex5.domain.FlightInformation;
import com.sfc.study.inflearn.entrance.ex5.repository.FlightInformationJdbcRepository;
import com.sfc.study.inflearn.entrance.ex5.repository.FlightInformationMemoryRepository;
import com.sfc.study.inflearn.entrance.ex5.repository.FlightInformationRepository;
import com.sfc.study.inflearn.entrance.ex5.repository.SpringDataJpaFlightInformationRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class FlightInformationService {

    private final FlightInformationRepository flightInformationRepository;

    public FlightInformationService(
            FlightInformationJdbcRepository flightInformationJdbcRepository
            , FlightInformationMemoryRepository flightInformationMemoryRepository
            , SpringDataJpaFlightInformationRepository SpringDataJpaFlightInformationRepository
    ) {
//        this.flightInformationRepository = flightInformationJdbcRepository;
//        this.flightInformationRepository = flightInformationMemoryRepository;
        this.flightInformationRepository = SpringDataJpaFlightInformationRepository;
    }

    public void save(FlightInformation flightInformation) {
        flightInformationRepository.save(flightInformation);
    }

    public List<FlightInformation> getFlightInformationList() {
        return flightInformationRepository.findAll();
    }

    public Optional<FlightInformation> getFlight(Long id) {
        return flightInformationRepository.findById(id);
    }

    public Optional<FlightInformation> getFlightByFlightNo(String flightNo) {
        return flightInformationRepository.findByFlightNo(flightNo);
    }


}
