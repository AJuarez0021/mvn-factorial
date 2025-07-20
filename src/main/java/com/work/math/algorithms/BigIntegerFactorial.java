package com.work.math.algorithms;

/**
 *
 * @author ajuar
 */
public class BigIntegerFactorial implements FactorialStrategy {

    @Override
    public String calculate(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("Factorial no definido para números negativos");
        }
        if (n > 10000) {
            throw new IllegalArgumentException("Límite de seguridad: n <= 10000");
        }

        java.math.BigInteger result = java.math.BigInteger.ONE;
        for (int i = 2; i <= n; i++) {
            result = result.multiply(java.math.BigInteger.valueOf(i));
        }
        return result.toString();
    }

    @Override
    public String getName() {
        return "BigInteger";
    }

    @Override
    public boolean supportsLargeNumbers() {
        return true;
    }

}
