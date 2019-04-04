package pl.szewczyk.elevator.system.States;

import pl.szewczyk.elevator.system.*;

public class IdleState implements Stateful {
    private Elevator elevator;

    public IdleState(Elevator elevator) {
        this.elevator = elevator;
    }

    @Override
    public void move() {
    }

    @Override
    public void receiveCommand(Orderable newCommand) {                                  //TO DO
        if (elevator.getStatus().getCurrentFloor() < newCommand.getFloorNumber())
            elevator.changeState(new MoveUpState(elevator));
        else
            elevator.changeState(new MoveDownState(elevator));
    }

    @Override
    public ElevatorStatus getStatus() {
        return new ElevatorStatus(elevator.getId(), elevator.getCurrentFloor(), null);
    }

}
