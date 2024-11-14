package com.sara.binance_tester.demo.model;

public class PerformanceMetrics {

    private final double averageTime;
    private final long bestTime;
    private final long worstTime;

    public PerformanceMetrics(double averageTime, long bestTime, long worstTime) {
        this.averageTime = averageTime;
        this.bestTime = bestTime;
        this.worstTime = worstTime;
    }

    public double getAverageTime() { return averageTime; }
    public long getBestTime() { return bestTime; }
    public long getWorstTime() { return worstTime; }

}
