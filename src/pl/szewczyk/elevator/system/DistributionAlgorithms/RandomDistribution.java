package pl.szewczyk.elevator.system.DistributionAlgorithms;

import pl.szewczyk.elevator.system.Commands.MoveToOrder;
import pl.szewczyk.elevator.system.Commands.ReceiveOrder;
import pl.szewczyk.elevator.system.Commands.SetOrderAsFirst;
import pl.szewczyk.elevator.system.DistributingOrders;
import pl.szewczyk.elevator.system.Elevator;

import java.util.ArrayList;

public class RandomDistribution implements DistributingOrders {

    @Override
    public void distributeOrder(ArrayList<Elevator> elevators, Integer floorNumber, Integer direction) {
        Elevator chosenElevator = elevators.get(getRandomElevatorId(elevators.size()));
        chosenElevator.receiveCommand(new MoveToOrder(floorNumber, new ReceiveOrder(floorNumber, new SetOrderAsFirst())));
    }

    private Integer getRandomElevatorId(Integer numberOfElevators) {
        return (int)(Math.random() * numberOfElevators);
    }
}
