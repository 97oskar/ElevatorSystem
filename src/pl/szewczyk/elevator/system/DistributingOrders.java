package pl.szewczyk.elevator.system;

import java.util.ArrayList;

public interface DistributingOrders {
    public void distributeOrder(ArrayList<Elevator> elevators, Integer floorNumber, Integer direction);
}
