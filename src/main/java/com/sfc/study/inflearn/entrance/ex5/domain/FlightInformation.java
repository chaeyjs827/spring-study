package com.sfc.study.inflearn.entrance.ex5.domain;

public class FlightInformation {

    private String flightNo;
    private String departureTime; // 개인 개발용으로 그냥 문자열로 진행
    private String arrivalTime; // 개인 개발용으로 그냥 문자열로 진행

    public String getFlightNo() {
        return flightNo;
    }

    public void setFlightNo(String flightNo) {
        this.flightNo = flightNo;
    }

    public String getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(String departureTime) {
        this.departureTime = departureTime;
    }

    public String getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(String arrivalTime) {
        this.arrivalTime = arrivalTime;
    }
}
