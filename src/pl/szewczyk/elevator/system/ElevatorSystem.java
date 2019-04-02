package pl.szewczyk.elevator.system;

import java.util.ArrayList;


public class ElevatorSystem {
    private Integer numberOfFloors;
    private ArrayList<Elevator> elevators = new ArrayList<Elevator>();

    public ElevatorSystem(Integer numberOfElevators, Integer numberOfFloors) {
        this.numberOfFloors = numberOfFloors;

        for (int id = 0; id < numberOfElevators; id++)
            elevators.add(new Elevator(id, 0));
    }

    public void pickUp(Integer floorNumber, Integer direction) {
        elevators.get(selectElevatorToOrder(floorNumber, direction)).addTargetFloor(new ElevatorOrder(floorNumber, false));
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

    private Integer selectElevatorToOrder(Integer floorNumber, Integer direction) {
        return (int) (Math.random() * this.elevators.size());                                                                                            //TO DO
    }
}
