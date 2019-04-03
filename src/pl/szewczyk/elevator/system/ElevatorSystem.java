package pl.szewczyk.elevator.system;

import pl.szewczyk.elevator.system.Commands.ElevatorOrder;

import java.util.ArrayList;


public class ElevatorSystem {
    private Integer numberOfFloors;
    private DistributingOrders ordersDistributor;
    private ArrayList<Elevator> elevators = new ArrayList<Elevator>();

    public ElevatorSystem(Integer numberOfElevators, Integer numberOfFloors, DistributingOrders distributionStrategy) {
        this.numberOfFloors = numberOfFloors;
        this.ordersDistributor = distributionStrategy;
        for (int id = 0; id < numberOfElevators; id++)
            elevators.add(new Elevator(id, 0));
    }

    public void pickUp(Integer floorNumber, Integer direction) {
        Orderable newOrder = new ElevatorOrder(floorNumber, direction);
        elevators.get(ordersDistributor.distributeOrder(status(), newOrder)).receiveOrder(newOrder);
    }

    public void update(Integer elevatorId, Integer currentFloor, Integer targetFloor) {
        elevators.get(elevatorId).updateState(currentFloor, targetFloor);
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
