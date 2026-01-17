package com.yurii.pavlenko;

/**
 * Data Transfer Object with exactly 7 fields.
 */
public record LifeStatsDTO(
        long years,        // 1
        long days,         // 2
        long hours,        // 3
        long minutes,      // 4
        long seconds,      // 5
        long milliseconds, // 6
        long totalMs       // 7
) {}