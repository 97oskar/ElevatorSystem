package pl.szewczyk.elevator.system.States;

import pl.szewczyk.elevator.system.*;

public class MoveDownState implements Stateful {
    private Elevator elevator;

    public MoveDownState(Elevator elevator) {
        this.elevator = elevator;
    }

    @Override
    public void move() {
        elevator.moveDown();

        if(isTargetFloorReached()) elevator.getCurrentCommand().execute(elevator);
    }

    @Override
    public void receiveOrder(Orderable newOrder) {
    }

    @Override
    public ElevatorStatus getStatus() {
        return new ElevatorStatus(elevator.getId(), elevator.getCurrentFloor(), elevator.getCurrentCommand().getFloorNumber());
    }

    private boolean isTargetFloorReached() {
        return elevator.getCurrentFloor().equals(elevator.getCurrentCommand().getFloorNumber());
    }
}
