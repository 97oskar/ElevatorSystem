package pl.szewczyk.elevator.system;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello elevators. I will be your master");

        ElevatorSystem elevatorSystem = new ElevatorSystem(4, 10, new RandomDistribution());

        elevatorSystem.pickUp(1, 1);
        elevatorSystem.pickUp(3, 1);

        while(true) {
            elevatorSystem.step();

            for(ElevatorStatus status : elevatorSystem.status())
                System.out.println(status);
        }

    }
}
