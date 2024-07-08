package com.sfc.study.jpa.ex2;

import com.sfc.study.inflearn.entrance.ex5.domain.FlightInformation;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Slf4j
public class FirstCacheTargetService {

    private final EntityManager entityManager;

    public FirstCacheTargetService(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    // 1. persist 메소드를 사용한 엔티티는 영속성 컨텍스트에 저장됩니다.
    @Transactional
    public void firstCacheTestByPersist() {
        log.info("[1]persist 메소드 사용 테스트 시작");
        FlightInformation flightInformation = new FlightInformation();
        flightInformation.setFlightNo("LOCK1233");
        flightInformation.setDepartureTime("13:00:00");
        flightInformation.setArrivalTime("15:00:00");
        entityManager.persist(flightInformation);
        log.info("[1]persist 메소드 사용 테스트 종료");

        log.info("[1]persist 메소드 사용 테스트 시작 : 입력 데이터 조회 시작");
        entityManager.find(FlightInformation.class, flightInformation.getId());
        log.info("[1]persist 메소드 사용 테스트 시작 : 입력 데이터 조회 종료");
    }

    // persist나 flush 같은 내용이 없으므로, 해당 메소드는 아무런 JPA 관련 로직이 실행되지 않습니다.
    @Transactional
    public void firstCacheTestByWithoutPersist() {
        log.info("[1-1]persist 메소드 미사용 테스트 시작");
        FlightInformation flightInformation = new FlightInformation();
        flightInformation.setFlightNo("LOCFK123");
        flightInformation.setDepartureTime("13:00:00");
        flightInformation.setArrivalTime("15:00:00");
        log.info("[1-1]persist 메소드 미사용 테스트 시작");
    }

    // 2. find 메소드로 조회된 엔티티는 영속성 컨텍스트에 저장됩니다.
    @Transactional
    public void firstCacheTestByFind() {
        log.info("[2]find 메소드 사용 시작");
        entityManager.find(FlightInformation.class, 1L);
        log.info("[2]find 메소드 사용 종료");

        log.info("[2]find 메소드 사용 시작 : 동일 조건 조회 시작");
        entityManager.find(FlightInformation.class, 1L);
        log.info("[2]find 메소드 사용 종료 : 동일 조건 조회 종료");
    }

    // 3. JPQL로 조회된 엔티티는 영속성 컨텍스트에 저장됩니다.
    // 조회만 영속성 컨텍스트로 관리되며, 삽입/삭제/수정은 대상이 아닙니다.(JPQL을 사용한 경우에만!!)

    // todo 그런데 캐시 조회가 안됨.. 이 부분은 추가 확인이 필요합니다.
    @Transactional
    public void firstCacheTestBySelectOfJPQL() {
        log.info("[3]JQPL 조회 시작");
        List<FlightInformation> flights = entityManager.createQuery("SELECT f FROM FlightInformation f WHERE f.flightNo = :flightNo", FlightInformation.class)
                .setParameter("flightNo", "AAB123")
                .getResultList();
        log.info("[3]JQPL 조회 종료");

        log.info("[3]JQPL 조회 시작 : 동일 조건 조회 시작");
        List<FlightInformation> flights2 = entityManager.createQuery("SELECT f FROM FlightInformation f WHERE f.flightNo = :flightNo", FlightInformation.class)
                .setParameter("flightNo", "AAC123")
                .getResultList();
        log.info("[3]JQPL 조회 종료 : 동일 조건 조회 종료");
    }

    // 4. merge 메소드로 병합한 경우 영속성 컨텍스트에 저장됩니다.
    @Transactional
    public void firstCacheTestByMerge() {
        log.info("[4]병합 시작");
        FlightInformation detachedFlight = new FlightInformation();
        detachedFlight.setId(1L);
        detachedFlight.setFlightNo("AAD123");
        FlightInformation mergedFlight = entityManager.merge(detachedFlight); // 엔티티를 병합하고 1차 캐시에 저장
        log.info("[4]병합 종료");

        log.info("[4]병합 데이터 조회 시작");
        entityManager.find(FlightInformation.class, mergedFlight.getId());
        log.info("[4]병합 데이터 조회 종료");
    }

    // 5. flush 메소드를 사용할 경우 영속성 컨텍스트에 저장됩니다.
    // flush 메소드는 persist 와 다르게 트랜잭션의 commit을 기다리지 않고 바로 DB에 반영을 합니다.
    // 단, flush도 트랜잭션이 롤백될 경우 DB 롤백을 진행 합니다.
    // 또한, flush는 단독으로 사용될 수 없고, persist를 사용해서 영속성 컨텍스트에 올려줘야 바르게 작동합니다.
    @Transactional
    public void firstCacheTestByFlush() {
        log.info("[5] flush 메소드 시작");
        FlightInformation flightInformation = new FlightInformation();
        flightInformation.setFlightNo("LOC@K123");
        flightInformation.setDepartureTime("13:00:00");
        flightInformation.setArrivalTime("15:00:00");
        entityManager.persist(flightInformation);
        entityManager.flush();
        log.info("[5] flush 메소드 종료");

        log.info("[5] JPQL 데이터 조회 시작");
        Query query = entityManager.createQuery("SELECT f FROM FlightInformation f WHERE f.flightNo = :flightNo", FlightInformation.class);
        query.setParameter("flightNo", "LOC@K123");
        FlightInformation result = (FlightInformation) query.getSingleResult();
        log.info("[5] JPQL 데이터 조회 종료");
        log.info("[5] find 데이터 조회 시작");
        entityManager.find(FlightInformation.class, result.getId());
        log.info("[5] find 데이터 조회 종료");
    }


}
