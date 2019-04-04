package pl.szewczyk.elevator.system.distribution.algorithms;

import pl.szewczyk.elevator.system.commands.*;
import pl.szewczyk.elevator.system.DistributingOrders;
import pl.szewczyk.elevator.system.Elevator;

import java.util.ArrayList;


public class FirstComeFirstServeDistributor implements DistributingOrders {

    @Override
    public void distributeOrder(ArrayList<Elevator> elevators, Integer floorNumber, Integer direction) {
        ArrayList<Elevator> freeElevators = findFreeElevators(elevators);

        if (freeElevators.isEmpty())
            findNearestElevator(elevators, floorNumber).receiveNewCommand(new SetCommandAsLast(new MoveToOrder(floorNumber, direction,
                                                                          new SetCommandAsFirst(new ReceiveOrder(floorNumber, new SetTargetAsFirst())))));
        else
            findNearestElevator(freeElevators, floorNumber).receiveNewCommand(new SetCommandAsLast(new MoveToOrder(floorNumber, direction,
                                                                              new SetCommandAsFirst(new ReceiveOrder(floorNumber, new SetTargetAsFirst())))));

    }

    private ArrayList<Elevator> findFreeElevators(ArrayList<Elevator> elevators) {
        ArrayList<Elevator> freeElevators = new ArrayList<Elevator>();

        for (Elevator elevator : elevators)
            if (elevator.getStatus().getTargetFloor() == null)
                freeElevators.add(elevator);

        return freeElevators;
    }

    private Elevator findNearestElevator(ArrayList<Elevator> elevators, Integer floorNumber) {
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
