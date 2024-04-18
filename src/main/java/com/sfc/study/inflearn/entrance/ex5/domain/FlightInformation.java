package com.sfc.study.inflearn.entrance.ex5.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class FlightInformation {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String flightNo;
    private String departureTime; // 개인 개발용으로 그냥 문자열로 진행
    private String arrivalTime; // 개인 개발용으로 그냥 문자열로 진행

}
