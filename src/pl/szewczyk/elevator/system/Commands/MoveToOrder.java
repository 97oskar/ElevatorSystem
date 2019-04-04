package pl.szewczyk.elevator.system.Commands;

import pl.szewczyk.elevator.system.Elevator;
import pl.szewczyk.elevator.system.Orderable;
import pl.szewczyk.elevator.system.Stateful;
import pl.szewczyk.elevator.system.States.MoveDownState;
import pl.szewczyk.elevator.system.States.MoveUpState;
import pl.szewczyk.elevator.system.States.ReceiveOrderState;

public class MoveToOrder implements Orderable {
    private Integer floorNumber;
    private Orderable addingOrderCommand;


    public MoveToOrder(Integer floorNumber, Orderable addingOrderCommand) {
        this.floorNumber = floorNumber;
        this.addingOrderCommand = addingOrderCommand;
    }

    @Override
    public void execute(Elevator elevator) {
        elevator.removeExecutedCommand();
        addingOrderCommand.execute(elevator);
        elevator.updateState();
    }

    @Override
    public void setElevatorState(Elevator elevator) {
        elevator.changeState(selectState(elevator));
    }

    @Override
    public Integer getFloorNumber() {
        return floorNumber;
    }

    @Override
    public void setFloorNumber(Integer floorNumber) {

    }

    private Stateful selectState(Elevator elevator) {
        Integer currentFloor = elevator.getCurrentFloor();

        if(currentFloor.equals(floorNumber))
            return new ReceiveOrderState(elevator);
        else if(currentFloor < floorNumber)
            return new MoveUpState(elevator);
        else
            return new MoveDownState(elevator);
    }
}
