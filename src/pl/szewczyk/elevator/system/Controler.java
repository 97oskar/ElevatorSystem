package pl.szewczyk.elevator.system;

import java.util.ArrayList;

public class Controler {

    private DistributingOrders distributionStrategy;

    public Controler(DistributingOrders distributionStrategy) {
        this.distributionStrategy = distributionStrategy;
    }

    public Integer chooseElevatorToOrder(ArrayList<ElevatorStatus> elevatorStatuses, ElevatorOrder order) {
        return distributionStrategy.distributeOrder(elevatorStatuses, order);
    }
}
