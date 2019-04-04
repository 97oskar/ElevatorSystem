package pl.szewczyk.elevator.system.commands;

import pl.szewczyk.elevator.system.Elevator;
import pl.szewczyk.elevator.system.Orderable;

public class SetTargetAsLast implements Orderable {
    private Integer floorNumber;

    @Override
    public void execute(Elevator elevator) {
        elevator.addCommandAsLast(new MoveToTarget(floorNumber));
    }

    @Override
    public void setElevatorState(Elevator elevator) {}

    @Override
    public Integer getFloorNumber() {
        return floorNumber;
    }

    @Override
    public void setFloorNumber(Integer floorNumber) {
        this.floorNumber = floorNumber;
    }
}
