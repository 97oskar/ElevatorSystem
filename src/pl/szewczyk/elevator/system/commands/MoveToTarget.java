package pl.szewczyk.elevator.system.commands;

import pl.szewczyk.elevator.system.Elevator;
import pl.szewczyk.elevator.system.Orderable;
import pl.szewczyk.elevator.system.Stateful;
import pl.szewczyk.elevator.system.states.MoveDownState;
import pl.szewczyk.elevator.system.states.MoveUpState;
import pl.szewczyk.elevator.system.states.ReceiveOrderState;

public class MoveToTarget implements Orderable {
    private Integer floorNumber;

    public MoveToTarget(Integer floorNumber) {
        this.floorNumber = floorNumber;
    }

    @Override
    public void execute(Elevator elevator) {
        elevator.removeExecutedCommand();
        elevator.updateState();
    }

    @Override
    public void setElevatorState(Elevator elevator) {
        elevator.changeState(selectState(elevator));
    }

    @Override
    public Integer getFloorNumber() {
        return floorNumber;
    }

    @Override
    public void setFloorNumber(Integer floorNumber) {
        this.floorNumber = floorNumber;
    }

    private Stateful selectState(Elevator elevator) {
        Integer currentFloor = elevator.getCurrentFloor();

        if(currentFloor.equals(floorNumber))
            return new ReceiveOrderState(elevator);
        else if(currentFloor < floorNumber)
            return new MoveUpState(elevator);
        else
            return new MoveDownState(elevator);
    }
}
