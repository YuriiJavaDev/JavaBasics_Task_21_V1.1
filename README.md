# Player Registration System (JavaBasics_Task_21_V1.1)

## 📌 Compliance with Requirements
This implementation fulfills all criteria of Task 21:

"Imagine you're creating a form to register a new player.
Write a program that first asks for the player's name (a string) and then their age (an integer).
The program should then display the player's age and name, each on a new line.
**Requirements:**
- The program should use the Scanner class to read data from the keyboard.
- The program should request and read the player's name as a string using Scanner.
- The program should request and read the player's age as an integer using Scanner.
- The integer (the player's age) should first be displayed on a separate line.
- The player's name should be displayed on the next line." -

while maintaining an enterprise-grade architecture:
- **Scanner usage:** Implemented in `PlayerNameProvider` and `PlayerAgeProvider`.
- **Sequential Output:** Age is printed first, followed by the Name on a new line.
- **Data Types:** Handles String for names and numeric values for age.

## 🚀 Architectural Stack
- **SRP:** Each task (input, logic, output) is isolated.
- **Precision:** Uses `TimeUnit` for fractional age decomposition.
- **Localization:** Locked to `Locale.US` for consistent floating-point input.

## 📌 Implementation Details
This solution strictly follows **Task 21 requirements** while applying **SOLID principles**:
- **Scanner Integration:** Encapsulated in Provider classes for clean input handling.
- **Sequential Output:** Per requirements, Age (years) is printed first, followed by Name.
- **Data Safety:** Uses Java `record` for immutable data transfer between layers.

## 🛠 Features
* **Logic/UI Separation:** Business math is isolated from `System.out`.
* **System API:** Uses `TimeUnit` for reliable time unit conversions.
* **Input Validation:** Prevents invalid characters in names and handles decimal separators.

## 📋 Standard Output Format
```text
Enter player name (Only letters):
Bob
Enter age. IMPORTANT: Use a POINT ('.') for decimals:
32.4896
32
Decomposed Age: 32 years, 178 days, 19 hours, 50 minutes, 0 seconds, 960 ms
Bob
Total Life in MS: 1025293800960
```

## 💻 Code Example

Project Structure:

src/com/yurii/pavlenko/

    ├── Task_21_App.java            # Main Entry Point
    ├── PlayerNameProvider.java     # UI: Name Input
    ├── PlayerAgeProvider.java      # UI: Age Input
    ├── LifeCalculatorService.java  # Business Logic
    ├── LifeStatsDTO.java           # Data Container
    └── ResultPrinter.java          # UI: Output

Code
```java
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
```

## ⚖️ License
This project is licensed under the **MIT License**.

Copyright (c) 2026 Yurii Pavlenko

Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files...

License: [MIT](LICENSE)
