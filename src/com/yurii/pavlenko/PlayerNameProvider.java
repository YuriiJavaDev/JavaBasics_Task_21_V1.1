package com.yurii.pavlenko;

import java.util.Scanner;

public class PlayerNameProvider {
    private static final String NAME_PATTERN = "^[a-zA-Zа-яА-ЯіІїЇєЄ\\s]+$";

    public String get(Scanner scanner) {
        while (true) {
            System.out.println("Enter player name (Only letters):");
            String input = scanner.nextLine().trim();
            if (input.matches(NAME_PATTERN) && input.length() > 1) {
                return input.substring(0, 1).toUpperCase() + input.substring(1).toLowerCase();
            }
            System.out.println("Error: Name contains invalid characters or numbers!");
        }
    }
}