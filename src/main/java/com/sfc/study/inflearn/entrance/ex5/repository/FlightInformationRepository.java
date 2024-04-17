package com.sfc.study.inflearn.entrance.ex5.repository;

import com.sfc.study.inflearn.entrance.ex5.domain.FlightInformation;

import java.util.List;

public interface FlightInformationRepository {

    void save(FlightInformation flightInformation);

    List<FlightInformation> getFlightList();

    FlightInformation getFlight();

}
