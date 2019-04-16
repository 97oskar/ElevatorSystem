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

            return validateFloorNumber(value);
        } catch (Exception e) {
            return defaultValue;
        }
    }

    public static String[] getString() {
        try {
            String[] input = scanner.nextLine().trim().split(" ");

            validateCommandString(input);

            return  input;
        } catch (Exception e) {
            System.out.println("Invalid operation");
            return null;
        }
    }

    private static void validateCommandString(String[] input) {
        if(input.length > 2) {
            input[1] = String.valueOf(validateFloorNumber(Integer.parseInt(input[1])));
            input[2] = String.valueOf(validateDirectionValue(Integer.parseInt(input[2])));
        }
    }

    private static Integer validateDirectionValue(Integer value) {
        return (int) Math.signum(value);
    }

    public static Integer validateFloorNumber(Integer value) {
        if (0 > value)
            return 0;
        else if(value > maximumNumber)
            return maximumNumber;
        else
            return value;
    }
}

