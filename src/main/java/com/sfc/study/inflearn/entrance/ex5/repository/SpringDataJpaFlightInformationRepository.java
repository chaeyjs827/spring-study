package com.sfc.study.inflearn.entrance.ex5.repository;

import com.sfc.study.inflearn.entrance.ex5.domain.FlightInformation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * JpaRepository를 상속받으면, Spring JPA 가 구현체를 자동으로 등록해줍니다.
 * 그 구현체를 가져다 쓰기만 하면 됩니다.
 */
public interface SpringDataJpaFlightInformationRepository
        extends JpaRepository<FlightInformation, Long>
                , FlightInformationRepository {

    @Override
    Optional<FlightInformation> findByFlightNo(String flightNo);

}
