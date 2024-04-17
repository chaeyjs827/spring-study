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
        flightInformationService.save();
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
