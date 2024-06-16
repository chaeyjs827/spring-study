package com.sfc.study.redis.benchmark.controller;

import com.sfc.study.redis.benchmark.service.RedisBenchMarkService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RedisBenchMarkController {

    private final RedisBenchMarkService benchMarkService;

    public RedisBenchMarkController(RedisBenchMarkService benchMarkService) {
        this.benchMarkService = benchMarkService;
    }

    @GetMapping("/benchmark")
    public String benchmark(@RequestParam(defaultValue = "1000") int operations) {
        benchMarkService.benchMark(operations);
        return "Benchmark completed for " + operations + " operations";
    }
}