package com.work.math.algorithms;

/**
 *
 * @author ajuar
 */
public class RecursiveFactorial implements FactorialStrategy {

    @Override
    public String calculate(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("Factorial no definido para números negativos");
        }
        if (n > 20) {
            throw new IllegalArgumentException("Recursión limitada a n <= 20 para evitar desbordamiento");
        }
        return String.valueOf(calculateRecursive(n));
    }

    private long calculateRecursive(int n) {
        return n <= 1 ? 1 : n * calculateRecursive(n - 1);
    }

    @Override
    public String getName() {
        return "Recursivo";
    }

    @Override
    public boolean supportsLargeNumbers() {
        return false;
    }

}
