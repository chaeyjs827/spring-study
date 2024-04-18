package com.sfc.study.inflearn.entrance.ex5.controller;

import com.sfc.study.inflearn.entrance.ex5.domain.FlightInformation;
import com.sfc.study.inflearn.entrance.ex5.service.FlightInformationService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/inflearn/entrance/ex5")
public class FlightInformationController {

    private final FlightInformationService flightInformationService;

    public FlightInformationController(
            FlightInformationService flightInformationService
    ) {
        this.flightInformationService = flightInformationService;
    }

    @PostMapping("")
    public void save() {
        FlightInformation flightInformation = new FlightInformation();
        flightInformation.setFlightNo("test1234");
        flightInformation.setDepartureTime("2024-04-16 00:00:00");
        flightInformation.setArrivalTime("2024-04-16 00:00:00");
        flightInformationService.save(flightInformation);
    }

    @GetMapping("/list")
    @ResponseBody
    public List<FlightInformation> getFlightInformationList() {
        return flightInformationService.getFlightInformationList();
    }


    @GetMapping("/{id}")
    @ResponseBody
    public String getFlightInformation(@PathVariable String id) {
        flightInformationService.getFlight();
        return null;
    }
}
