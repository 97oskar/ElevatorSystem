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

            if(currentDirection.equals(1) && commandToAdd.getFloorNumber() < targetFloor)
                elevator.addCommandAsFirst(commandToAdd);
            else if(currentDirection.equals(1))
                elevator.addCommandAsLast(commandToAdd);
            else if(commandToAdd.getFloorNumber() > targetFloor)
                elevator.addCommandAsFirst(commandToAdd);
            else
                elevator.addCommandAsLast(commandToAdd);
        } else {
            elevator.addCommandAsLast(commandToAdd);
        }

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
