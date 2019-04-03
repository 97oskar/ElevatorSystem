package pl.szewczyk.elevator.system;

import pl.szewczyk.elevator.system.DistributionAlgorithms.RandomDistribution;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello elevators. I will be your master");

        ElevatorSystem elevatorSystem = new ElevatorSystem(1, 10, new RandomDistribution());

        elevatorSystem.pickUp(2, 1);
        elevatorSystem.pickUp(9, -1);

        for(int i=0; i<50; i++) {
            System.out.println("###########");
            for(ElevatorStatus status : elevatorSystem.status())
                System.out.println(status);

            elevatorSystem.step();
        }

    }
}
