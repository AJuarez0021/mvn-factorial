package com.work.math.algorithms;

/**
 *
 * @author ajuar
 */
public class IterativeFactorial implements FactorialStrategy {

    @Override
    public String calculate(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("Factorial no definido para números negativos");
        }
        if (n > 20) {
            throw new IllegalArgumentException("Iterativo básico limitado a n <= 20");
        }

        long result = 1;
        for (int i = 2; i <= n; i++) {
            result *= i;
        }
        return String.valueOf(result);
    }

    @Override
    public String getName() {
        return "Iterativo";
    }

    @Override
    public boolean supportsLargeNumbers() {
        return false;
    }

}
