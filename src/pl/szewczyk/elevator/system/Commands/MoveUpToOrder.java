package pl.szewczyk.elevator.system.Commands;

import pl.szewczyk.elevator.system.Elevator;
import pl.szewczyk.elevator.system.Orderable;
import pl.szewczyk.elevator.system.States.MoveUpState;

public class MoveUpToOrder implements Orderable {
    private Integer floorNumber;

    public MoveUpToOrder(Integer floorNumber) {
        this.floorNumber = floorNumber;
    }

    @Override
    public void execute(Elevator elevator) {
        elevator.removeCurrentCommand();
        Integer targetFloor = elevator.receiveTargetFloorFromInput();

        if(elevator.getCurrentFloor() < targetFloor)
            elevator.receiveCommand(new MoveUpToTarget(targetFloor));
        else
            elevator.receiveCommand(new MoveDownToTarget(targetFloor));

        elevator.updateState();
    }

    @Override
    public void setState(Elevator elevator) {
        elevator.changeState(new MoveUpState(elevator));
    }

    @Override
    public Integer getFloorNumber() {
        return floorNumber;
    }
}
