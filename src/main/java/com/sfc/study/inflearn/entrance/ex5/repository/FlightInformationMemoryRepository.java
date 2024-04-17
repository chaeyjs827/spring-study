package com.sfc.study.inflearn.entrance.ex5.repository;

import com.sfc.study.inflearn.entrance.ex5.domain.FlightInformation;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class FlightInformationMemoryRepository implements FlightInformationRepository {

    public FlightInformationMemoryRepository(

    ) {

    }

    @Override
    public void save(FlightInformation flightInformation) {

        System.out.println("memory save 실행");
    }

    @Override
    public List<FlightInformation> getFlightList() {
        System.out.println("memory getFlightList 실행");
        return List.of();
    }

    @Override
    public FlightInformation getFlight() {
        System.out.println("memory getFlight 실행");
        return null;
    }
}
