package com.sara.binance_tester.demo.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class BinanceTestService {

    private final RestTemplate restTemplate = new RestTemplate();

    public long testEndpoint(String url) {
        long startTime = System.nanoTime();
        try {
            restTemplate.getForObject(url, String.class);
        } catch (Exception e) {
            System.err.println("Request failed: " + e.getMessage());
        }
        return System.nanoTime() - startTime;
    }
}