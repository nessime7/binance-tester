package com.sara.binance_tester.demo.model;

public class PerformanceReport {

    private final PerformanceMetrics cachePerformance;
    private final PerformanceMetrics realTimePerformance;

    public PerformanceReport(PerformanceMetrics cachePerformance, PerformanceMetrics realTimePerformance) {
        this.cachePerformance = cachePerformance;
        this.realTimePerformance = realTimePerformance;
    }

    public PerformanceMetrics getCachePerformance() {
        return cachePerformance;
    }

    public PerformanceMetrics getRealTimePerformance() {
        return realTimePerformance;
    }
}
