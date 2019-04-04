package pl.szewczyk.elevator.system.Commands;

import pl.szewczyk.elevator.system.Elevator;
import pl.szewczyk.elevator.system.Orderable;

public class SetTargetWithCheck implements Orderable {
    private Integer floorNumber;

    @Override
    public void execute(Elevator elevator) {
        if(elevator.getCurrentCommand() != null) {
            Integer targetFloor = elevator.getCurrentCommand().getFloorNumber();
            Integer currentFloor = elevator.getCurrentFloor();
            Integer currentDirection = (int) Math.signum(targetFloor - currentFloor);

            if (currentDirection.equals(1) && floorNumber < targetFloor)
                elevator.addCommandAsFirst(new MoveToTarget(floorNumber));
            else if (currentDirection.equals(1))
                elevator.addCommandAsLast(new MoveToTarget(floorNumber));
            else if (floorNumber > targetFloor)
                elevator.addCommandAsFirst(new MoveToTarget(floorNumber));
            else
                elevator.addCommandAsLast(new MoveToTarget(floorNumber));
        } else {
            elevator.addCommandAsLast(new MoveToTarget(floorNumber));
        }
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
