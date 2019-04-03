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

    public void pickUp(Integer floorNumber, Integer direction) {
        ordersDistributor.distributeOrder(elevators, floorNumber, direction);
    }

    public void step() {
        for (Elevator elevator : elevators)
            elevator.move();
    }

    public ArrayList<ElevatorStatus> status() {
        ArrayList<ElevatorStatus> elevatorsStatuses = new ArrayList<ElevatorStatus>();
        for (Elevator elevator : elevators)
            elevatorsStatuses.add(elevator.getStatus());

        return elevatorsStatuses;
    }
}
