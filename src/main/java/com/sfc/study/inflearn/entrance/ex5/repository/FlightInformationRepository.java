package com.sfc.study.inflearn.entrance.ex5.repository;

import com.sfc.study.inflearn.entrance.ex5.domain.FlightInformation;

import java.util.List;
import java.util.Optional;

public interface FlightInformationRepository {

    FlightInformation save(FlightInformation flightInformation);

    List<FlightInformation> findAll();

    Optional<FlightInformation> findById(Long id);

    Optional<FlightInformation> findByFlightNo(String flightNo);

}
