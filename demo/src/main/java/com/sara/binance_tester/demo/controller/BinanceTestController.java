package com.sara.binance_tester.demo.controller;

import com.sara.binance_tester.demo.model.PerformanceMetrics;
import com.sara.binance_tester.demo.model.PerformanceReport;
import com.sara.binance_tester.demo.service.BinanceTestService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping
public class BinanceTestController {

    private final BinanceTestService testService;

    public BinanceTestController(BinanceTestService testService) {
        this.testService = testService;
    }

    @PostMapping("/compare")
    public PerformanceReport comparePerformance(@RequestParam String symbol) {
        List<Long> cacheTimes = new ArrayList<>();
        List<Long> realTimeTimes = new ArrayList<>();

        // Hit cache-enabled endpoint 100 times
        String baseUrl = "http://localhost:8080/pairs";
        for (int i = 0; i < 100; i++) {
            long responseTime = testService.testEndpoint(baseUrl + "/" + symbol + "?cache=true");
            cacheTimes.add(responseTime);
        }

        // Hit real-time endpoint 100 times
        for (int i = 0; i < 100; i++) {
            long responseTime = testService.testEndpoint(baseUrl + "/" + symbol + "?cache=false");
            realTimeTimes.add(responseTime);
        }

        return new PerformanceReport(
                calculateMetrics(cacheTimes),
                calculateMetrics(realTimeTimes)
        );
    }

    private PerformanceMetrics calculateMetrics(List<Long> responseTimes) {
        double average = responseTimes.stream().mapToDouble(Long::doubleValue).average().orElse(0.0);
        long bestTime = Collections.min(responseTimes);
        long worstTime = Collections.max(responseTimes);
        return new PerformanceMetrics(average, bestTime, worstTime);
    }
}