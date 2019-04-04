package pl.szewczyk.elevator.system.Commands;

import pl.szewczyk.elevator.system.Elevator;
import pl.szewczyk.elevator.system.Orderable;

public class SetCommandWithCheck implements Orderable {
    private Orderable commandToAdd;

    public SetCommandWithCheck(Orderable commandToAdd) {
        this.commandToAdd = commandToAdd;
    }

    @Override
    public void execute(Elevator elevator) {
        if(elevator.getCurrentCommand() != null) {
            Integer targetFloor = elevator.getCurrentCommand().getFloorNumber();
            Integer currentFloor = elevator.getCurrentFloor();
            Integer currentDirection = (int) Math.signum(targetFloor - currentFloor);

            if(shouldCommandBeAddedFirst(targetFloor, currentDirection))
                elevator.addCommandAsFirst(commandToAdd);
            else
                elevator.addCommandAsLast(commandToAdd);
        } else {
            elevator.addCommandAsLast(commandToAdd);
        }

    }

    private boolean shouldCommandBeAddedFirst(Integer targetFloor, Integer currentDirection) {
        if(isMovingUpAndBelowTarget(targetFloor, currentDirection))
            return true;
        else if(isMovingUp(currentDirection))
            return false;
        else return !isBelowTarget(targetFloor);
    }

    private boolean isMovingUp(Integer currentDirection) {
        return currentDirection.equals(1);
    }

    private boolean isMovingUpAndBelowTarget(Integer targetFloor, Integer currentDirection) {
        return isMovingUp(currentDirection) && isBelowTarget(targetFloor);
    }

    private boolean isBelowTarget(Integer targetFloor) {
        return commandToAdd.getFloorNumber() < targetFloor;
    }

    @Override
    public void setElevatorState(Elevator elevator) {}

    @Override
    public Integer getFloorNumber() {
        return null;
    }

    @Override
    public void setFloorNumber(Integer floorNumber) {}
}
