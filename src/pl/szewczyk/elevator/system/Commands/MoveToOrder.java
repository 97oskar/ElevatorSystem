package pl.szewczyk.elevator.system.Commands;

import pl.szewczyk.elevator.system.Elevator;
import pl.szewczyk.elevator.system.Orderable;
import pl.szewczyk.elevator.system.States.MoveDownState;
import pl.szewczyk.elevator.system.States.MoveUpState;

public class MoveToOrder implements Orderable {
    private Integer floorNumber;

    public MoveToOrder(Integer floorNumber) {
        this.floorNumber = floorNumber;
    }

    @Override
    public void execute(Elevator elevator) {
        elevator.removeCurrentCommand();
        Integer targetFloor = elevator.receiveTargetFloorFromInput();

        elevator.receiveCommand(new MoveToTarget(targetFloor));

        elevator.updateState();
    }

    @Override
    public void setState(Elevator elevator) {
        if(elevator.getCurrentFloor() < floorNumber)
            elevator.changeState(new MoveUpState(elevator));
        else
            elevator.changeState(new MoveDownState(elevator));
    }

    @Override
    public Integer getFloorNumber() {
        return floorNumber;
    }
}
