package pl.szewczyk.elevator.system.DistributionAlgorithms;

import pl.szewczyk.elevator.system.Commands.MoveToOrder;
import pl.szewczyk.elevator.system.Commands.ReceiveOrder;
import pl.szewczyk.elevator.system.Commands.SetOrderAsFirst;
import pl.szewczyk.elevator.system.DistributingOrders;
import pl.szewczyk.elevator.system.Elevator;
import pl.szewczyk.elevator.system.ElevatorStatus;

import java.util.ArrayList;

import static java.lang.Math.signum;
import static java.lang.Math.abs;

public class FirstComeFirstServeDistribution implements DistributingOrders {

    @Override
    public void distributeOrder(ArrayList<Elevator> elevators, Integer floorNumber, Integer direction) {
        Elevator chosenElevator = findFreeElevator(elevators);

        if(chosenElevator != null)
            chosenElevator.receiveCommand(new MoveToOrder(floorNumber, new ReceiveOrder(floorNumber, new SetOrderAsFirst())));
        else
            findNearestElevator(elevators, floorNumber)
                    .receiveCommand(new MoveToOrder(floorNumber, new ReceiveOrder(floorNumber, new SetOrderAsFirst())));
    }

    private Elevator findFreeElevator(ArrayList<Elevator> elevators) {
        for(Elevator elevator : elevators) {
            if(elevator.getStatus().getTargetFloor() == null)
                return elevator;
        }
        return null;
    }

    private Elevator findNearestElevator(ArrayList<Elevator> elevators, Integer floorNumber) {
        Elevator nearestElevator = elevators.get(0);
        Integer smallestDifference = Math.abs(floorNumber - elevators.get(0).getStatus().getCurrentFloor());

        for(Elevator elevator : elevators) {
            Integer difference = Math.abs(floorNumber - elevator.getStatus().getCurrentFloor());

            if(smallestDifference > difference) {
                nearestElevator = elevator;
                smallestDifference = difference;
            }
        }

        return nearestElevator;
    }

    private Elevator findNearestElevatorWithRightDirection(ArrayList<Elevator> elevators, Integer floorNumber, Integer direction) {
        Elevator nearestElevator = elevators.get(0);
        Integer smallestDifference = Math.abs(floorNumber - elevators.get(0).getStatus().getCurrentFloor());

        for(Elevator elevator : elevators) {
            ElevatorStatus status = elevator.getStatus();

            if(signum(status.getTargetFloor() - status.getCurrentFloor()) == signum(direction)) {
                Integer difference = abs(floorNumber - status.getCurrentFloor());

                if(smallestDifference > difference) {
                    nearestElevator = elevator;
                    smallestDifference = difference;
                }
            }

        }

        return nearestElevator;
    }
}
