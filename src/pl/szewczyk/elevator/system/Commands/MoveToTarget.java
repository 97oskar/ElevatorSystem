package pl.szewczyk.elevator.system.Commands;

import pl.szewczyk.elevator.system.Elevator;
import pl.szewczyk.elevator.system.Orderable;
import pl.szewczyk.elevator.system.States.MoveDownState;
import pl.szewczyk.elevator.system.States.MoveUpState;

public class MoveToTarget implements Orderable {
    private Integer floorNumber;

    public MoveToTarget(Integer floorNumber) {
        this.floorNumber = floorNumber;
    }

    @Override
    public void execute(Elevator elevator) {
        elevator.removeCurrentCommand();
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
    }}
