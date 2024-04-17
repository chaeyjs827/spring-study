package com.sfc.study.inflearn.entrance.ex5.controller;

import com.sfc.study.inflearn.entrance.ex5.service.FlightInformationService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/inflearn/entrance/ex5")
public class FlightInformationController {

    private final FlightInformationService flightInformationService;

    public FlightInformationController(
            FlightInformationService flightInformationService
    ) {
        this.flightInformationService = flightInformationService;
    }

    @GetMapping("/list")
    @ResponseBody
    public String getFlightInformationList() {
        flightInformationService.getFlightInformationList();
        return null;
    }


    @GetMapping("/{id}")
    @ResponseBody
    public String getFlightInformation(@PathVariable String id) {
        flightInformationService.getFlight();
        return null;
    }
}
