package com.yurii.pavlenko;

import java.util.Scanner;
import java.util.Locale;

public class Task_21_App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in).useLocale(Locale.US);

        // Components injection
        PlayerNameProvider nameProvider = new PlayerNameProvider();
        PlayerAgeProvider ageProvider = new PlayerAgeProvider();
        LifeCalculatorService service = new LifeCalculatorService();
        ResultPrinter printer = new ResultPrinter();

        // Execution logic
        String name = nameProvider.get(scanner);
        double age = ageProvider.get(scanner);

        LifeStatsDTO stats = service.calculateDecomposedStats(service.convertYearsToMilliseconds(age));

        printer.print(name, stats);
        scanner.close();
    }
}