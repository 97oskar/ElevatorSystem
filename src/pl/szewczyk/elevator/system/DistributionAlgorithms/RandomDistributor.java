package pl.szewczyk.elevator.system.DistributionAlgorithms;

import pl.szewczyk.elevator.system.Commands.*;
import pl.szewczyk.elevator.system.DistributingOrders;
import pl.szewczyk.elevator.system.Elevator;

import java.util.ArrayList;

public class RandomDistributor implements DistributingOrders {

    @Override
    public void distributeOrder(ArrayList<Elevator> elevators, Integer floorNumber, Integer direction) {
        Elevator chosenElevator = elevators.get(getRandomElevatorId(elevators.size()));
        chosenElevator.receiveNewCommand(new SetCommandAsLast(new MoveToOrder(floorNumber, direction,
                                         new SetCommandAsFirst(new ReceiveOrder(floorNumber, new SetTargetAsFirst())))));
    }

    private Integer getRandomElevatorId(Integer numberOfElevators) {
        return (int)(Math.random() * numberOfElevators);
    }
}
