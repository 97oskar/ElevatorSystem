package pl.szewczyk.elevator.system.Commands;

import pl.szewczyk.elevator.system.Elevator;
import pl.szewczyk.elevator.system.Orderable;
import pl.szewczyk.elevator.system.States.MoveUpState;

public class MoveUpToTarget implements Orderable {
    private Integer floorNumber;

    public MoveUpToTarget(Integer floorNumber) {
        this.floorNumber = floorNumber;
    }

    @Override
    public void execute(Elevator elevator) {
        elevator.removeCurrentCommand();
    }

    @Override
    public void setState(Elevator elevator) {
        elevator.changeState(new MoveUpState(elevator));
    }

    @Override
    public Integer getFloorNumber() {
        return floorNumber;
    }}
