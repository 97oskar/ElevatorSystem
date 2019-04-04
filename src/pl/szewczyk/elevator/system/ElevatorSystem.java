package pl.szewczyk.elevator.system;

import java.util.ArrayList;


public class ElevatorSystem {
    private Integer numberOfFloors;
    private DistributingOrders ordersDistributor;
    private ArrayList<Elevator> elevators = new ArrayList<Elevator>();

    public ElevatorSystem(Integer numberOfElevators, Integer numberOfFloors, DistributingOrders distributionStrategy) {
        this.numberOfFloors = numberOfFloors;
        this.ordersDistributor = distributionStrategy;

        for (int id = 0; id < numberOfElevators; id++)
            elevators.add(new Elevator(id, 0, numberOfFloors));
    }

    public void run() {
        while(true) {
            System.out.println("--------------------------");
            for(ElevatorStatus status : status())
                System.out.println(status);
            System.out.println("--------------------------");
            System.out.println("Order elevator:  pickup <floor number> <direction>");
            System.out.println("Next step: s");
            System.out.println("Insert operation:");

            String[] command = InputValidator.getString();
            switch (command[0]) {
                case "pickup" : pickUp(Integer.parseInt(command[1]), Integer.parseInt(command[2]));
                                break;
                case "s"   : step();
                                break;
            }
        }
    }

    public void pickUp(Integer floorNumber, Integer direction) {
        ordersDistributor.distributeOrder(elevators, floorNumber, direction);
    }

    public void step() {
        for (Elevator elevator : elevators)
            elevator.takeStep();
    }

    public ArrayList<ElevatorStatus> status() {
        ArrayList<ElevatorStatus> elevatorsStatuses = new ArrayList<ElevatorStatus>();
        for (Elevator elevator : elevators)
            elevatorsStatuses.add(elevator.getStatus());

        return elevatorsStatuses;
    }
}
