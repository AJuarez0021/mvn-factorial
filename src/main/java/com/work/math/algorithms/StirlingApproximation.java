package com.work.math.algorithms;

/**
 *
 * @author ajuar
 */
public class StirlingApproximation implements FactorialStrategy {

    @Override
    public String calculate(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("Factorial no definido para números negativos");
        }
        if (n == 0) {
            return "1";
        }

        double result = stirlingApproximation(n);
        return String.format("%.2e", result);
    }

    private double stirlingApproximation(int n) {
        if (n == 0) {
            return 1.0;
        }
        return Math.sqrt(2 * Math.PI * n) * Math.pow(n / Math.E, n);
    }

    @Override
    public String getName() {
        return "Aproximación de Stirling";
    }

    @Override
    public boolean supportsLargeNumbers() {
        return true;
    }
}
