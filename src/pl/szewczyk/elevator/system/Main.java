package pl.szewczyk.elevator.system;

import pl.szewczyk.elevator.system.DistributionAlgorithms.FirstComeFirstServeDistributor;
import pl.szewczyk.elevator.system.DistributionAlgorithms.MyDistributor;

public class Main {
    public static void main(String[] args) {
        InputValidator.setMaximumNumber(10);
        ElevatorSystem elevatorSystem = new ElevatorSystem(1, 5, new MyDistributor());
        elevatorSystem.run();
    }
}
