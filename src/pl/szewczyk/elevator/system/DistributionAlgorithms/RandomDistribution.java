package pl.szewczyk.elevator.system.DistributionAlgorithms;

import pl.szewczyk.elevator.system.Commands.MoveToOrder;
import pl.szewczyk.elevator.system.Commands.ReceiveOrder;
import pl.szewczyk.elevator.system.DistributingOrders;
import pl.szewczyk.elevator.system.Elevator;

import java.util.ArrayList;

public class RandomDistribution implements DistributingOrders {

    @Override
    public void distributeOrder(ArrayList<Elevator> elevators, Integer floorNumber, Integer direction) {
        Elevator chosenElevator = elevators.get(getRandomElevatorId(elevators.size()));
        Integer floorNumberOfChosenElevator = chosenElevator.getCurrentFloor();

        if(floorNumberOfChosenElevator.equals(floorNumber))
            chosenElevator.receiveCommand(new ReceiveOrder());
        else
            chosenElevator.receiveCommand(new MoveToOrder(floorNumber));
    }

    private Integer getRandomElevatorId(Integer numberOfElevators) {
        return (int)(Math.random() * numberOfElevators);
    }
}
