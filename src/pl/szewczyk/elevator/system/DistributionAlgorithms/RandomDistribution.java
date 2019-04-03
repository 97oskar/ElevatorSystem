package pl.szewczyk.elevator.system.DistributionAlgorithms;

import pl.szewczyk.elevator.system.DistributingOrders;
import pl.szewczyk.elevator.system.ElevatorOrder;
import pl.szewczyk.elevator.system.ElevatorStatus;

import java.util.ArrayList;

public class RandomDistribution implements DistributingOrders {

    @Override
    public Integer distributeOrder(ArrayList<ElevatorStatus> elevatorStatuses, ElevatorOrder order) {
        return (int) (Math.random() * elevatorStatuses.size());
    }
}
