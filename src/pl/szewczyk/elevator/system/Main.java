package pl.szewczyk.elevator.system;

import pl.szewczyk.elevator.system.DistributionAlgorithms.PrioritizingSameDirectionDistributor;


public class Main {
    public static void main(String[] args) {
        validateArguments(args);

        InputValidator.setMaximumNumber(Integer.parseInt(args[1]));
        ElevatorSystem elevatorSystem = new ElevatorSystem(Integer.parseInt(args[0]), Integer.parseInt(args[1]), new PrioritizingSameDirectionDistributor());
        elevatorSystem.run();
    }

    private static void validateArguments(String[] args){
        if(args.length < 2) {
            System.out.println("You must provide 2 arguments: <number of elevator> <number of floors>");
            System.exit(0);
        }

    }
}
