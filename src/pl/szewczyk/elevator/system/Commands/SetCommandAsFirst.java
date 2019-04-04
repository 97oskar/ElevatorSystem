package pl.szewczyk.elevator.system.Commands;

import pl.szewczyk.elevator.system.Elevator;
import pl.szewczyk.elevator.system.Orderable;

public class SetCommandAsFirst implements Orderable {
    Orderable commandToAdd;

    public SetCommandAsFirst(Orderable commandToAdd) {
        this.commandToAdd = commandToAdd;
    }

    @Override
    public void execute(Elevator elevator) {
        elevator.addCommandAsFirst(commandToAdd);
    }

    @Override
    public void setElevatorState(Elevator elevator) {}

    @Override
    public Integer getFloorNumber() {
        return null;
    }

    @Override
    public void setFloorNumber(Integer floorNumber) { }
}
