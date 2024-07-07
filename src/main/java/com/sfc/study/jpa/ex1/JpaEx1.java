package com.sfc.study.jpa.ex1;

import com.sfc.study.inflearn.entrance.ex5.domain.FlightInformation;
import jakarta.persistence.EntityManager;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Slf4j
public class JpaEx1 {

    private final EntityManager entityManager;

    public JpaEx1(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Transactional
    public void case1() {
        log.info("cas1 시작");
        log.info("[case1] 1차 조회 시작");
        FlightInformation flight1 = getFlight(1L);
        log.info("[case1] 1차 조회 종료");

        log.info("[case1] 2차 조회 시작");
        FlightInformation flight2 = getFlight(1L);
        log.info("[case1] 2차 조회 종료");

    }

    private FlightInformation getFlight(Long flightId) {
        return entityManager.find(FlightInformation.class, flightId);
    }

    @Transactional
    public void processFlight() {
        // 1.엔티티 저장
        // entityManager.persist(flight)를 호출하면, flight 엔티티는 영속성 컨텍스트에 저장됩니다.
        // 이 시점에서 엔티티는 영속 상태가 되며, 트랜잭션이 커밋되면 데이터베이스에 반영됩니다.
        FlightInformation flight = new FlightInformation();
        flight.setFlightNo("AA123");
        flight.setDepartureTime("2024-07-10 10:00");
        flight.setArrivalTime("2024-07-10 12:00");
        log.info("[processFlight] persist 시작");
        entityManager.persist(flight);
        log.info("[processFlight] persist 종료");

        // 2. 엔티티 조회
        // entityManager.find(FlightInformation.class, flight.getId())를 호출하면,
        // 영속성 컨텍스트는 먼저 캐시를 확인하고, 캐시에 없으면 데이터베이스에서 조회합니다.
        // 조회된 엔티티는 영속성 컨텍스트에 저장됩니다.

        // 이미 persist() 시 영속성 컨테스트에 저장이 되어, 영속성 컨텍스트에서 조회합니다.
        log.info("[processFlight] getId 조회 : 영속성 컨텍스트 캐시 조회");
        FlightInformation persistedFlight = entityManager.find(FlightInformation.class, flight.getId());
        log.info("[processFlight] getId 종료");

        // 저장, 조회된 이력이 없기 때문에 DB에서 직접 조회합니다. 이와 함께 해당 내역은 영속성 컨텍스트에 저장됩니다.
        log.info("[processFlight] 1L 조회 : DB조회 후 영속성 컨텍스트 저장");
        FlightInformation persistedFlightBy1L = entityManager.find(FlightInformation.class, 1L);
        log.info("[processFlight] 1L 조회 종료");

        // 3. 엔티티 수정
        // 영속 상태의 엔티티를 수정하면, 영속성 컨텍스트는 변경 사항을 추적합니다.
        // 트랜잭션이 커밋될 때 변경 사항이 데이터베이스에 반영됩니다.
        persistedFlight.setDepartureTime("2024-07-10 11:00");

        // 4. 엔티티 삭제
        // entityManager.remove(persistedFlight)를 호출하면, 영속성 컨텍스트는 엔티티를 삭제 상태로 변경합니다.
        // 트랜잭션이 커밋될 때 엔티티가 데이터베이스에서 삭제됩니다.
        log.info("[processFlight] 삭제 시작");
        Long insertedId = flight.getId();
        entityManager.remove(persistedFlight);
        // 이 시점까지 DB에서 delete는 되지 않고
        log.info("[processFlight] 삭제 종료");

        log.info("[processFlight] getId 삭제 후 조회");
        FlightInformation persistedFlight3 = entityManager.find(FlightInformation.class, insertedId); // 영속성 콘텍스트가 이미 알고 있어 따로 조회 x
        FlightInformation persistedFlight4 = entityManager.find(FlightInformation.class, 2L); // 영속성 콘텍스트에 없으니 db 조회

        // 영속성 컨텍스트에서 관리되는 객체는 데이터에 수정이 포착되면 commit 될 때 update 문이 자동으로 실행됩니다.
        persistedFlight4.setFlightNo("test123123");

        log.info("[processFlight] getId 삭제 후 조회 종료");

        // 트랜잭션이 commit되는 시점에 실제 delete 쿼리가 실행됩니다.
    }


}
