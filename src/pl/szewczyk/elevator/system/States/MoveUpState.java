package pl.szewczyk.elevator.system.States;

import pl.szewczyk.elevator.system.*;

public class MoveUpState implements Stateful {
    private Elevator elevator;

    public MoveUpState(Elevator elevator) {
        this.elevator = elevator;
    }

    @Override
    public void move() {
        elevator.moveUp();

        if (isTargetFloorReached()) elevator.getCurrentCommand().execute(elevator);
    }

    @Override
    public void receiveCommand(Orderable newCommand) {
    }

    @Override
    public ElevatorStatus getStatus() {
        return new ElevatorStatus(elevator.getId(), elevator.getCurrentFloor(), elevator.getCurrentCommand().getFloorNumber());
    }

    private boolean isTargetFloorReached() {
        return elevator.getCurrentFloor().equals(elevator.getCurrentCommand().getFloorNumber());
    }
}
