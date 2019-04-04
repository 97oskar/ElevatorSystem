package pl.szewczyk.elevator.system.States;

import pl.szewczyk.elevator.system.*;

public class IdleState implements Stateful {
    private Elevator elevator;

    public IdleState(Elevator elevator) {
        this.elevator = elevator;
    }

    @Override
    public void takeStep() {
    }

    @Override
    public void receiveNewCommand(Orderable newCommand) {                                  //TO DO
        if (elevator.getStatus().getCurrentFloor() < newCommand.getFloorNumber())
            elevator.changeState(new MoveUpState(elevator));
        else
            elevator.changeState(new MoveDownState(elevator));
//        elevator.addCommandAsLast(newCommand);
//        elevator.updateState();
    }

    @Override
    public ElevatorStatus getStatus() {
        return new ElevatorStatus(elevator.getId(), elevator.getCurrentFloor(), null);
    }

}
