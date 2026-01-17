package com.yurii.pavlenko;

import java.util.Scanner;

public class PlayerAgeProvider {
    private static final double MAXIMUM_ALLOWED_AGE = 120.0;

    public double get(Scanner scanner) {
        while (true) {
            System.out.println("Enter age. IMPORTANT: Use a POINT ('.') for decimals:");
            if (scanner.hasNextDouble()) {
                double age = scanner.nextDouble();
                if (age > 0 && age <= MAXIMUM_ALLOWED_AGE) return age;
                System.out.println("Error: Age must be between 0 and " + MAXIMUM_ALLOWED_AGE);
            } else {
                System.out.println("Error: Invalid format! Use numbers and a point separator.");
                scanner.next();
            }
        }
    }
}