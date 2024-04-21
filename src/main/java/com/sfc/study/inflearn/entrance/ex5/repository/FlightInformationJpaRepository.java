package com.sfc.study.inflearn.entrance.ex5.repository;

import com.sfc.study.inflearn.entrance.ex5.domain.FlightInformation;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@Transactional
public class FlightInformationJpaRepository implements FlightInformationRepository {

    /**
     * jpa 는 EntityManager 라는 걸 통해 작동한다.
     * jpa dependency 를 추가하면 스프링이 자동으로 EntityManager를 생성한다. (application.yml를 바탕으로 생성)
     */
    private final EntityManager entityManager;

    public FlightInformationJpaRepository(
            EntityManager entityManager
    ) {
        this.entityManager = entityManager;
    }

    @Override
    public FlightInformation save(FlightInformation flightInformation) {
        entityManager.persist(flightInformation);
        return null;
    }

    @Override
    public List<FlightInformation> findAll() {
        return entityManager.createQuery("SELECT fi FROM FlightInformation fi", FlightInformation.class).getResultList();
    }

    @Override
    public Optional<FlightInformation> findById(Long id) {
        return Optional.ofNullable(entityManager.find(FlightInformation.class, id));
    }

    @Override
    public Optional<FlightInformation> findByFlightNo(String flightNo) {
        List<FlightInformation> result = entityManager.createQuery(
                "SELECT fi FROM FlightInformation fi WHERE fi.flightNo = :flightNo"
                        , FlightInformation.class
                )
                .setParameter("flightNo", flightNo)
                .getResultList();
        return result.stream().findAny();
    }
}
