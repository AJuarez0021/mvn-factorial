package com.work.math.util;

/**
 *
 * @author ajuar
 */
public class PerformanceMetrics {

    private long startTime;
    private long endTime;
    private long memoryBefore;
    private long memoryAfter;

    public void start() {
        memoryBefore = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
        startTime = System.nanoTime();
    }

    public void end() {
        endTime = System.nanoTime();
        memoryAfter = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
    }

    public long getExecutionTimeNs() {
        return endTime - startTime;
    }

    public double getExecutionTimeMs() {
        return (endTime - startTime) / 1_000_000.0;
    }

    public long getMemoryUsed() {
        return memoryAfter - memoryBefore;
    }

    @Override
    public String toString() {
        return String.format("Tiempo: %.2f ms, Memoria: %d bytes",
                getExecutionTimeMs(), getMemoryUsed());
    }
}
