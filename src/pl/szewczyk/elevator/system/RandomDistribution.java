package pl.szewczyk.elevator.system;

import java.util.ArrayList;

public class RandomDistribution implements DistributingOrders {

    @Override
    public Integer distributeOrder(ArrayList<ElevatorStatus> elevatorStatuses, ElevatorOrder order) {
        return (int) (Math.random() * elevatorStatuses.size());
    }
}
