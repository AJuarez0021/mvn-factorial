package com.work.math.algorithms;

/**
 *
 * @author ajuar
 */
public class OptimizedFactorial implements FactorialStrategy {

    private final java.util.Map<Integer, java.math.BigInteger> cache = new java.util.concurrent.ConcurrentHashMap<>();

    @Override
    public String calculate(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("Factorial no definido para números negativos");
        }
        if (n > 10000) {
            throw new IllegalArgumentException("Límite de seguridad: n <= 10000");
        }

        return calculateOptimized(n).toString();
    }

    private java.math.BigInteger calculateOptimized(int n) {
        if (n <= 1) {
            return java.math.BigInteger.ONE;
        }

        // Verificar caché
        if (cache.containsKey(n)) {
            return cache.get(n);
        }

        // Divide y vencerás
        java.math.BigInteger result = divideAndConquer(1, n);
        cache.put(n, result);
        return result;
    }

    private java.math.BigInteger divideAndConquer(int start, int end) {
        if (start > end) {
            return java.math.BigInteger.ONE;
        }
        if (start == end) {
            return java.math.BigInteger.valueOf(start);
        }

        if (end - start == 1) {
            return java.math.BigInteger.valueOf(start).multiply(java.math.BigInteger.valueOf(end));
        }

        int mid = start + (end - start) / 2;
        java.math.BigInteger left = divideAndConquer(start, mid);
        java.math.BigInteger right = divideAndConquer(mid + 1, end);

        return left.multiply(right);
    }

    public void clearCache() {
        cache.clear();
    }

    @Override
    public String getName() {
        return "Optimizado (Divide y Vencerás + Caché)";
    }

    @Override
    public boolean supportsLargeNumbers() {
        return true;
    }
}
