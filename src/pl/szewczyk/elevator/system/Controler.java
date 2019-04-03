package pl.szewczyk.elevator.system;

import pl.szewczyk.elevator.system.Commands.ElevatorOrder;

import java.util.ArrayList;

public class Controler {

    private DistributingOrders distributionStrategy;

    public Controler(DistributingOrders distributionStrategy) {
        this.distributionStrategy = distributionStrategy;
    }

}
