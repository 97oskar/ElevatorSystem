package pl.szewczyk.elevator.system;

import java.util.Scanner;

public class InputValidator {
    private static Integer maximumNumber;
    private static Scanner scanner = new Scanner(System.in);

    public static void setMaximumNumber(Integer number) {
        maximumNumber = number;
    }

    public static Integer getInteger() {
        return getInteger(0);
    }

    public static Integer getInteger(Integer defaultValue) {
        try {
            Integer value = scanner.nextInt();

            if (0 <= value && value < maximumNumber)
                return value;
            else
                return 0;
        } catch (Exception e) {
            return defaultValue;
        }
    }

    public static String[] getString() {
        try {
            String[] input = scanner.nextLine().trim().split(" ");
                return  input;
        } catch (Exception e) {
            System.out.println("Invalid operation");
            return null;
        }
    }

}

