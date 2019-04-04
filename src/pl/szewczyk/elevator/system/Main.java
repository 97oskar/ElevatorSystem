package pl.szewczyk.elevator.system;

import pl.szewczyk.elevator.system.DistributionAlgorithms.FirstComeFirstServeDistribution;
import pl.szewczyk.elevator.system.DistributionAlgorithms.RandomDistribution;

public class Main {
    public static void main(String[] args) {
        InputValidator.setMaximumNumber(10);
        ElevatorSystem elevatorSystem = new ElevatorSystem(10, 10, new FirstComeFirstServeDistribution());
        elevatorSystem.run();
    }
}
