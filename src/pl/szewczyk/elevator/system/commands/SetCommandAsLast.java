package pl.szewczyk.elevator.system.commands;

import pl.szewczyk.elevator.system.Elevator;
import pl.szewczyk.elevator.system.Orderable;

public class SetCommandAsLast implements Orderable {
    Orderable commandToAdd;

    public SetCommandAsLast(Orderable commandToAdd) {
        this.commandToAdd = commandToAdd;
    }

    @Override
    public void execute(Elevator elevator) {
        elevator.addCommandAsLast(commandToAdd);
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
