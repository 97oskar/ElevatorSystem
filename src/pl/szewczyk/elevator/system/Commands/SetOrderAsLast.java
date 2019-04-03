package pl.szewczyk.elevator.system.Commands;

import pl.szewczyk.elevator.system.Elevator;
import pl.szewczyk.elevator.system.Orderable;

public class SetOrderAsLast implements Orderable {
    private Integer floorNumber;

    @Override
    public void execute(Elevator elevator) {
        elevator.addCommandAsLast(new MoveToTarget(floorNumber));
    }

    @Override
    public void setState(Elevator elevator) {}

    @Override
    public Integer getFloorNumber() {
        return floorNumber;
    }

    @Override
    public void setFloorNumber(Integer floorNumber) {
        this.floorNumber = floorNumber;
    }
}
