package com.work.math;

import com.work.math.algorithms.OptimizedFactorial;
import com.work.math.algorithms.FactorialCalculator;
import com.work.math.util.ConsoleHelper;

/**
 *
 * @author ajuar
 */
public class Main {

    public static void main(String[] args) {
        FactorialCalculator calculator = new FactorialCalculator();
        
        // Mostrar estrategias disponibles
        ConsoleHelper.println("Estrategias disponibles:");
        calculator.getAvailableStrategies().forEach(s -> ConsoleHelper.println("- " + s));
        ConsoleHelper.println();
        
        // Pruebas con números pequeños
        ConsoleHelper.println("=== Pruebas con números pequeños ===");
        testSmallNumbers(calculator);
        
        // Pruebas con números grandes
        ConsoleHelper.println("\n=== Pruebas con números grandes ===");
        testLargeNumbers(calculator);
        
        // Comparación de rendimiento
        ConsoleHelper.println("\n=== Comparación de rendimiento ===");
        calculator.compareStrategies(100);
        
        // Demostración de uso específico
        ConsoleHelper.println("=== Demostración de uso específico ===");
        demonstrateSpecificUsage(calculator);
    }
    
    private static void testSmallNumbers(FactorialCalculator calculator) {
        int[] testNumbers = {0, 1, 5, 10, 15};
        
        for (int n : testNumbers) {
            ConsoleHelper.printf("Factorial de %d:\n", n);
            
            for (String strategy : calculator.getAvailableStrategies()) {
                try {
                    calculator.setStrategy(strategy);
                    String result = calculator.calculate(n);
                    ConsoleHelper.printf("  %s: %s\n", calculator.getCurrentStrategyName(), result);
                } catch (Exception e) {
                    ConsoleHelper.printf("  %s: Error - %s\n", calculator.getCurrentStrategyName(), e.getMessage());
                }
            }
            ConsoleHelper.println();
        }
    }
    
    private static void testLargeNumbers(FactorialCalculator calculator) {
        int[] largeNumbers = {50, 100, 500, 1000};
        
        for (int n : largeNumbers) {
            ConsoleHelper.printf("Factorial de %d con estrategias para números grandes:\n", n);
            
            String[] bigNumberStrategies = {"biginteger", "optimizado", "stirling"};
            
            for (String strategy : bigNumberStrategies) {
                try {
                    calculator.setStrategy(strategy);
                    String result = calculator.calculateWithMetrics(n);
                    ConsoleHelper.printf("  %s\n", result.replace("\n", "\n  "));
                } catch (Exception e) {
                    ConsoleHelper.printf("  %s: Error - %s\n", strategy, e.getMessage());
                }
                ConsoleHelper.println();
            }
        }
    }
    
    private static void demonstrateSpecificUsage(FactorialCalculator calculator) {
        // Uso recomendado según el caso
        ConsoleHelper.println("Recomendaciones de uso:");
        ConsoleHelper.println("- Para n <= 20: usar 'recursivo' o 'iterativo'");
        ConsoleHelper.println("- Para n <= 1000: usar 'biginteger'");
        ConsoleHelper.println("- Para n > 1000: usar 'optimizado'");
        ConsoleHelper.println("- Para aproximaciones rápidas: usar 'stirling'");
        ConsoleHelper.println();
        
        // Ejemplo de uso óptimo
        calculator.setStrategy("optimizado");
        ConsoleHelper.println("Calculando 200! con estrategia optimizada:");
        ConsoleHelper.println(calculator.calculateWithMetrics(200));
        
        // Limpiar caché si es necesario
        if (calculator.getCurrentStrategy() instanceof OptimizedFactorial optimizedFactorial) {
            optimizedFactorial.clearCache();
            ConsoleHelper.println("Caché limpiado.");
        }
    }
}
