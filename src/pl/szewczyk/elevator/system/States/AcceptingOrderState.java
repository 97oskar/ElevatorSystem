package pl.szewczyk.elevator.system.States;

import pl.szewczyk.elevator.system.Elevator;
import pl.szewczyk.elevator.system.ElevatorStatus;
import pl.szewczyk.elevator.system.Orderable;
import pl.szewczyk.elevator.system.Stateful;

public class AcceptingOrderState implements Stateful {
    private Elevator elevator;

    public AcceptingOrderState(Elevator elevator) {
        this.elevator = elevator;
    }

    @Override
    public void move() {
        elevator.getCurrentCommand().execute(elevator);
    }

    @Override
    public void receiveCommand(Orderable newOrder) {}

    @Override
    public ElevatorStatus getStatus() {
        return new ElevatorStatus(elevator.getId(), elevator.getCurrentFloor(), elevator.getCurrentCommand().getFloorNumber());
    }
}
