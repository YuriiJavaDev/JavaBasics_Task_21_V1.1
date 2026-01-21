package com.yurii.pavlenko;

import java.util.concurrent.TimeUnit;

public class LifeCalculatorService {

    private static final double DAYS_IN_A_YEAR = 365.25;

    public long convertYearsToMilliseconds(double years) {
        long msInOneDay = TimeUnit.DAYS.toMillis(1);
        return (long) (years * DAYS_IN_A_YEAR * msInOneDay);
    }

    public LifeStatsDTO calculateDecomposedStats(long totalMs) {
        long remainingMs = totalMs;

        // 1. Calculation of years
        long msInYear = (long) (DAYS_IN_A_YEAR * TimeUnit.DAYS.toMillis(1));
        long years = remainingMs / msInYear;
        remainingMs %= msInYear;

        // 2. System balance calculation
        long days = TimeUnit.MILLISECONDS.toDays(remainingMs);
        remainingMs -= TimeUnit.DAYS.toMillis(days);

        long hours = TimeUnit.MILLISECONDS.toHours(remainingMs);
        remainingMs -= TimeUnit.HOURS.toMillis(hours);

        long minutes = TimeUnit.MILLISECONDS.toMinutes(remainingMs);
        remainingMs -= TimeUnit.MINUTES.toMillis(minutes);

        long seconds = TimeUnit.MILLISECONDS.toSeconds(remainingMs);
        long ms = remainingMs % 1000;

        return new LifeStatsDTO(years, days, hours, minutes, seconds, ms, totalMs);
    }
}