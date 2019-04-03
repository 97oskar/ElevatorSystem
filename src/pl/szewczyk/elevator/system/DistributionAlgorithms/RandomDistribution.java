package pl.szewczyk.elevator.system.DistributionAlgorithms;

import pl.szewczyk.elevator.system.DistributingOrders;
import pl.szewczyk.elevator.system.ElevatorStatus;
import pl.szewczyk.elevator.system.Orderable;

import java.util.ArrayList;

public class RandomDistribution implements DistributingOrders {

    @Override
    public Integer distributeOrder(ArrayList<ElevatorStatus> elevatorStatuses, Orderable order) {
        return (int) (Math.random() * elevatorStatuses.size());
    }
}
