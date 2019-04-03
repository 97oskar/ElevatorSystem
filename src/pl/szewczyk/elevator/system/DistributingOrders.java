package pl.szewczyk.elevator.system;

import java.util.ArrayList;

public interface DistributingOrders {
    public Integer distributeOrder(ArrayList<ElevatorStatus> elevatorStatuses, Orderable order);
}
