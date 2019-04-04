package pl.szewczyk.elevator.system.Commands;

import pl.szewczyk.elevator.system.Elevator;
import pl.szewczyk.elevator.system.Orderable;
import pl.szewczyk.elevator.system.States.ReceiveOrderState;

public class ReceiveOrder implements Orderable {
    private Integer floorNumber;
    private Orderable addingOrderCommand;

    public ReceiveOrder(Integer floorNumber, Orderable addingOrderCommand) {
        this.floorNumber = floorNumber;
        this.addingOrderCommand = addingOrderCommand;
    }

    @Override
    public void execute(Elevator elevator) {
        elevator.removeExecutedCommand();

        Integer targetFloor = elevator.receiveTargetFloorFromInput();
        addingOrderCommand.setFloorNumber(targetFloor);
        addingOrderCommand.execute(elevator);
        elevator.updateState();
    }

    @Override
    public void setElevatorState(Elevator elevator) {
        elevator.setNextDirection(null);
        elevator.changeState(new ReceiveOrderState(elevator));
    }

    @Override
    public Integer getFloorNumber() {
        return floorNumber;
    }

    @Override
    public void setFloorNumber(Integer floorNumber) {
        this.floorNumber = floorNumber;
    }
}
