package com.work.math.algorithms;

import com.work.math.util.ConsoleHelper;
import com.work.math.util.PerformanceMetrics;

/**
 *
 * @author ajuar
 */
public class FactorialCalculator {
    private final java.util.Map<String, FactorialStrategy> strategies;
    private FactorialStrategy currentStrategy;
    
    public FactorialCalculator() {
        strategies = new java.util.HashMap<>();
        strategies.put("recursivo", new RecursiveFactorial());
        strategies.put("iterativo", new IterativeFactorial());
        strategies.put("biginteger", new BigIntegerFactorial());
        strategies.put("optimizado", new OptimizedFactorial());
        strategies.put("stirling", new StirlingApproximation());
        
        // Estrategia por defecto
        currentStrategy = strategies.get("optimizado");
    }

    public FactorialStrategy getCurrentStrategy() {
        return currentStrategy;
    }
    
    public void setStrategy(String strategyName) {
        FactorialStrategy strategy = strategies.get(strategyName.toLowerCase());
        if (strategy == null) {
            throw new IllegalArgumentException("Estrategia no válida: " + strategyName);
        }
        currentStrategy = strategy;
    }
    
    public String calculate(int n) {
        return currentStrategy.calculate(n);
    }
    
    public String calculateWithMetrics(int n) {
        PerformanceMetrics metrics = new PerformanceMetrics();
        
        metrics.start();
        String result = currentStrategy.calculate(n);
        metrics.end();
        
        return String.format("Resultado: %s\nEstrategia: %s\nMétricas: %s",
                           result, currentStrategy.getName(), metrics);
    }
    
    public void compareStrategies(int n) {
        ConsoleHelper.println("=== Comparación de Estrategias para n = " + n + " ===\n");
        
        for (java.util.Map.Entry<String, FactorialStrategy> entry : strategies.entrySet()) {
            FactorialStrategy strategy = entry.getValue();
            
            try {
                PerformanceMetrics metrics = new PerformanceMetrics();
                
                metrics.start();
                String result = strategy.calculate(n);
                metrics.end();
                
                ConsoleHelper.printf("%s:\n", strategy.getName());
                ConsoleHelper.printf("  Resultado: %s\n", 
                                result.length() > 50 ? result.substring(0, 50) + "..." : result);
                ConsoleHelper.printf("  Métricas: %s\n", metrics);
                ConsoleHelper.printf("  Soporta números grandes: %s\n\n", 
                                strategy.supportsLargeNumbers() ? "Sí" : "No");
                
            } catch (Exception e) {
                ConsoleHelper.printf("%s:\n", strategy.getName());
                ConsoleHelper.printf("  Error: %s\n\n", e.getMessage());
            }
        }
    }
    
    public java.util.Set<String> getAvailableStrategies() {
        return strategies.keySet();
    }
    
    public String getCurrentStrategyName() {
        return currentStrategy.getName();
    }
}
