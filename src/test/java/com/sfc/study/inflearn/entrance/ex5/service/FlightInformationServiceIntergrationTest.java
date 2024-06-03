package com.sfc.study.inflearn.entrance.ex5.service;

import com.sfc.study.inflearn.entrance.ex5.domain.FlightInformation;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
@Transactional
@Slf4j
class FlightInformationServiceIntergrationTest {

    @Autowired
    FlightInformationService flightInformationService;


    @Test
    void save() {
        log.info("[save] 시작");
        FlightInformation flightInformation = new FlightInformation();
        flightInformation.setFlightNo("intergration1234");
        flightInformation.setDepartureTime("2024-04-16 00:00:00");
        flightInformation.setArrivalTime("2024-04-16 00:00:00");

        flightInformationService.save(flightInformation);
        log.info("저장 완료");
        log.info("[save] 종료");
    }

    @Test
    void getFlightInformationList() {
        log.info("[getFlightInformationList] 시작");
        List<FlightInformation> list = flightInformationService.getFlightInformationList();
        list.forEach(System.out::println);
        list.forEach(
                flightInformation -> {
                    log.info(flightInformation.getFlightNo() + ", "
                    + flightInformation.getDepartureTime() + ", "
                    + flightInformation.getFlightNo());
                }
        );
        log.info("[getFlightInformationList] 종료");
    }

    @Test
    void getFlight() {

    }
}