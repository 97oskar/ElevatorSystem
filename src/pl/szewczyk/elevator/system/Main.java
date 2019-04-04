package pl.szewczyk.elevator.system;

import pl.szewczyk.elevator.system.DistributionAlgorithms.PrioritizingSameDirectionDistributor;

public class Main {
    public static void main(String[] args) {
        InputValidator.setMaximumNumber(10);
        ElevatorSystem elevatorSystem = new ElevatorSystem(1, 5, new PrioritizingSameDirectionDistributor());
        elevatorSystem.run();
    }
}
