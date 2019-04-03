package pl.szewczyk.elevator.system.Commands;

import pl.szewczyk.elevator.system.Elevator;
import pl.szewczyk.elevator.system.Orderable;
import pl.szewczyk.elevator.system.States.ReceiveOrderState;

public class ReceiveOrder implements Orderable {
    private Integer floorNumber;

    public ReceiveOrder(Integer floorNumber) {
        this.floorNumber = floorNumber;
    }

    @Override
    public void execute(Elevator elevator) {
        elevator.removeExecutedCommand();

        Integer targetFloor = elevator.receiveTargetFloorFromInput();
        elevator.addCommandAsFirst(new MoveToTarget(targetFloor));
        elevator.updateState();
    }

    @Override
    public void setState(Elevator elevator) {
        elevator.changeState(new ReceiveOrderState(elevator));
    }

    @Override
    public Integer getFloorNumber() {
        return floorNumber;
    }
}
