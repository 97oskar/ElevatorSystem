package pl.szewczyk.elevator.system;

import java.util.Scanner;

public class InputValidator {
    private Integer maximumNumber;
    private Scanner scanner = new Scanner(System.in);

    InputValidator(Integer maximumNumber) {
        this.maximumNumber = maximumNumber;
    }

    public Integer getInteger() {
        return getInteger(0);
    }

    public Integer getInteger(Integer defaultValue) {
        try{
            Integer value = scanner.nextInt();

            if(0 <= value && value < maximumNumber)
                return value;
            else
                return 0;
        } catch (Exception e) {
            return defaultValue;
        }
    }

}

