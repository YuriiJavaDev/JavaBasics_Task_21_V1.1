package com.yurii.pavlenko;

/**
 * Final View layer aligned with Task 21 requirements.
 * Requirements:
 * 1. Print age first (decomposed).
 * 2. Print name second.
 * 3. Each on a new line.
 */
public class ResultPrinter {
    public void print(String name, LifeStatsDTO stats) {
        // Requirement: Print age first (on separate lines as per breakdown)
        System.out.println(stats.years()); // Simple age as per requirements

        // Detailed breakdown (bonus for precision)
        System.out.printf("Decomposed Age: %d years, %d days, %d hours, %d minutes, %d seconds, %d ms%n",
                stats.years(), stats.days(), stats.hours(), stats.minutes(), stats.seconds(), stats.milliseconds());

        // Requirement: Print player name second
        System.out.println(name);

        // Technical info
        System.out.println("Total Life in MS: " + stats.totalMs());
    }
}