package com.work.math.algorithms;

/**
 *
 * @author ajuar
 */
public interface FactorialStrategy {

    String calculate(int n);

    String getName();

    boolean supportsLargeNumbers();
}
