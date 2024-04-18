package com.sfc.study.inflearn.entrance.ex5.service;

import com.sfc.study.inflearn.entrance.ex5.domain.FlightInformation;
import com.sfc.study.inflearn.entrance.ex5.repository.FlightInformationJdbcRepository;
import com.sfc.study.inflearn.entrance.ex5.repository.FlightInformationMemoryRepository;
import com.sfc.study.inflearn.entrance.ex5.repository.FlightInformationRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class FlightInformationService {

    private FlightInformationRepository flightInformationRepository;

    public FlightInformationService(
            FlightInformationJdbcRepository flightInformationJdbcRepository
            , FlightInformationMemoryRepository flightInformationMemoryRepository
    ) {
        this.flightInformationRepository = flightInformationJdbcRepository;
//        this.flightInformationRepository = flightInformationMemoryRepository;
    }

    public void save(FlightInformation flightInformation) {
        flightInformationRepository.save(flightInformation);
    }

    public List<FlightInformation> getFlightInformationList() {
        List<FlightInformation> list = flightInformationRepository.getFlightList();
        log.info(list.toString());
        return list;
    }

    public void getFlight() {
        flightInformationRepository.getFlight();
    }


}
