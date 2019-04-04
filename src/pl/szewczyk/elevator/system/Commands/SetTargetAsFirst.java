package pl.szewczyk.elevator.system.Commands;

import pl.szewczyk.elevator.system.Elevator;
import pl.szewczyk.elevator.system.Orderable;

public class SetTargetAsFirst implements Orderable {
    private Integer floorNumber;

    @Override
    public void execute(Elevator elevator) {
        elevator.addCommandAsFirst(new MoveToTarget(floorNumber));
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
