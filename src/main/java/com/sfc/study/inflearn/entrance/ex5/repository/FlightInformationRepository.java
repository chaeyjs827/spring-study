package com.sfc.study.inflearn.entrance.ex5.repository;

import com.sfc.study.inflearn.entrance.ex5.domain.FlightInformation;

import java.util.List;
import java.util.Optional;

public interface FlightInformationRepository {

    void save(FlightInformation flightInformation);

    List<FlightInformation> getFlightList();

    Optional<FlightInformation> getFlight(Long id);

    Optional<FlightInformation> getFlightByFlightNo(String flightNo);

}
