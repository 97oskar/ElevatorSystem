package pl.szewczyk.elevator.system;

import pl.szewczyk.elevator.system.DistributionAlgorithms.RandomDistribution;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello elevators. I will be your master");

        ElevatorSystem elevatorSystem = new ElevatorSystem(4, 10, new RandomDistribution());

        elevatorSystem.pickUp(4, 1);
        elevatorSystem.pickUp(6, 1);

        while(true) {
            System.out.println("###########");
            for(ElevatorStatus status : elevatorSystem.status())
                System.out.println(status);

            elevatorSystem.step();
        }

    }
}
