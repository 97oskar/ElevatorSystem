package pl.szewczyk.elevator.system.DistributionAlgorithms;

import pl.szewczyk.elevator.system.Commands.*;
import pl.szewczyk.elevator.system.DistributingOrders;
import pl.szewczyk.elevator.system.Elevator;

import java.util.ArrayList;


public class PrioritizingSameDirectionDistributor implements DistributingOrders {
    @Override
    public void distributeOrder(ArrayList<Elevator> elevators, Integer floorNumber, Integer direction) {
        ArrayList<Elevator> selectedElevators = new ArrayList<Elevator>();

        Elevator nearestFreeElevator = getNearestElevator(getFreeElevators(elevators), floorNumber);
        if(nearestFreeElevator != null)
            selectedElevators.add(nearestFreeElevator);

        Elevator nearestOnTheWayElevator = getNearestElevator(getElevatorsThatAreOnTheWay(getBusyElevators(elevators), floorNumber, direction), floorNumber);
        if(nearestOnTheWayElevator != null)
            selectedElevators.add(nearestOnTheWayElevator);

        Elevator selectedElevator = getNearestElevator(selectedElevators, floorNumber);

        if(selectedElevator != null)
            selectedElevator.receiveNewCommand(new SetCommandWithCheck(new MoveToOrder(floorNumber, direction,
                                               new SetCommandAsFirst(new ReceiveOrder(floorNumber, new SetTargetWithCheck())))));
        else
            getNearestElevator(elevators, floorNumber).receiveNewCommand(new SetCommandAsLast(new MoveToOrder(floorNumber, direction,
                                                                         new SetCommandAsFirst(new ReceiveOrder(floorNumber, new SetTargetWithCheck())))));

    }

    private ArrayList<Elevator> getElevatorsThatAreOnTheWay(ArrayList<Elevator> elevators, Integer floorNumber, Integer direction) {
        ArrayList<Elevator> onTheWayElevators = new ArrayList<Elevator>();

        for(Elevator elevator : elevators) {
            Integer elevatorTargetFloor = elevator.getCurrentCommand().getFloorNumber();
            Integer elevatorCurrentFloor = elevator.getCurrentFloor();
            Integer elevatorNextDirection = elevator.getNextDirection();
            Integer elevatorCurrentDirection = (int) Math.signum(elevatorTargetFloor - elevatorCurrentFloor);

            if(elevatorCurrentFloor < floorNumber && elevatorCurrentDirection.equals(1) && direction.equals(1) && direction.equals(elevatorNextDirection))  //!!
                onTheWayElevators.add(elevator);
            else if(elevatorCurrentFloor < floorNumber && elevatorCurrentDirection.equals(-1) && direction.equals(-1) && direction.equals(elevatorNextDirection))
                onTheWayElevators.add(elevator);
        }

            return onTheWayElevators;
    }

    private ArrayList<Elevator> getFreeElevators(ArrayList<Elevator> elevators) {
        ArrayList<Elevator> freeElevators = new ArrayList<Elevator>();

        for (Elevator elevator : elevators)
            if (elevator.getStatus().getTargetFloor() == null)
                freeElevators.add(elevator);

        return freeElevators;
    }

    private ArrayList<Elevator> getBusyElevators(ArrayList<Elevator> elevators) {
        ArrayList<Elevator> freeElevators = new ArrayList<Elevator>();

        for (Elevator elevator : elevators)
            if (elevator.getStatus().getTargetFloor() != null)
                freeElevators.add(elevator);

        return freeElevators;
    }

    private Elevator getNearestElevator(ArrayList<Elevator> elevators, Integer floorNumber) {
        if(elevators.isEmpty())
            return null;

        Elevator nearestElevator = elevators.get(0);
        Integer smallestDifference = Math.abs(floorNumber - elevators.get(0).getStatus().getCurrentFloor());

        for (Elevator elevator : elevators) {
            Integer difference = Math.abs(floorNumber - elevator.getStatus().getCurrentFloor());

            if (smallestDifference > difference) {
                nearestElevator = elevator;
                smallestDifference = difference;
            }
        }

        return nearestElevator;
    }
}
