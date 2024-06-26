package com.sfc.study.inflearn.entrance.ex5.repository;

import com.sfc.study.inflearn.entrance.ex5.domain.FlightInformation;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class FlightInformationMemoryRepository implements FlightInformationRepository {

    public FlightInformationMemoryRepository(

    ) {

    }

    @Override
    public FlightInformation save(FlightInformation flightInformation) {

        System.out.println("memory save 실행");

        return null;
    }

    @Override
    public List<FlightInformation> findAll() {
        System.out.println("memory getFlightList 실행");
        return List.of();
    }

    @Override
    public Optional<FlightInformation> findById(Long id) {
        System.out.println("memory getFlight 실행");
        return null;
    }

    @Override
    public Optional<FlightInformation> findByFlightNo(String flightNo) {
        return Optional.empty();
    }
}
