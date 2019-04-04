package pl.szewczyk.elevator.system.States;

import pl.szewczyk.elevator.system.Elevator;
import pl.szewczyk.elevator.system.ElevatorStatus;
import pl.szewczyk.elevator.system.Orderable;
import pl.szewczyk.elevator.system.Stateful;

public class ReceiveOrderState implements Stateful {
    private Elevator elevator;

    public ReceiveOrderState(Elevator elevator) {
        this.elevator = elevator;
    }

    @Override
    public void takeStep() {
        elevator.getCurrentCommand().execute(elevator);
    }

    @Override
    public void receiveNewCommand(Orderable newCommand) {}

    @Override
    public ElevatorStatus getStatus() {
        return new ElevatorStatus(elevator.getId(), elevator.getCurrentFloor(), null);
    }
}
