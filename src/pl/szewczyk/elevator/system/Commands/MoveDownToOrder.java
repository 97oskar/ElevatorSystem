package pl.szewczyk.elevator.system.Commands;

import pl.szewczyk.elevator.system.Elevator;
import pl.szewczyk.elevator.system.Orderable;
import pl.szewczyk.elevator.system.States.MoveDownState;

public class MoveDownToOrder implements Orderable {
    private Integer floorNumber;

    public MoveDownToOrder(Integer floorNumber) {
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
        elevator.changeState(new MoveDownState(elevator));
    }

    @Override
    public Integer getFloorNumber() {
        return floorNumber;
    }
}
