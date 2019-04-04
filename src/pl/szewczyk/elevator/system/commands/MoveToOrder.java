package pl.szewczyk.elevator.system.commands;

import pl.szewczyk.elevator.system.Elevator;
import pl.szewczyk.elevator.system.Orderable;
import pl.szewczyk.elevator.system.Stateful;
import pl.szewczyk.elevator.system.states.MoveDownState;
import pl.szewczyk.elevator.system.states.MoveUpState;
import pl.szewczyk.elevator.system.states.ReceiveOrderState;

public class MoveToOrder implements Orderable {
    private Integer floorNumber;
    private Integer direction;
    private Orderable addingOrderCommand;


    public MoveToOrder(Integer floorNumber, Integer direction, Orderable addingOrderCommand) {
        this.floorNumber = floorNumber;
        this.direction = direction;
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
        elevator.setNextDirection(direction);
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
