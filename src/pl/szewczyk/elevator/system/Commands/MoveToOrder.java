package pl.szewczyk.elevator.system.Commands;

import pl.szewczyk.elevator.system.Elevator;
import pl.szewczyk.elevator.system.Orderable;
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

        elevator.addCommandAsFirst(new ReceiveOrder(floorNumber, addingOrderCommand));
        elevator.updateState();
    }

    @Override
    public void setState(Elevator elevator) {
        if(elevator.getCurrentFloor().equals(floorNumber))
            elevator.changeState(new ReceiveOrderState(elevator));
        else if(elevator.getCurrentFloor() < floorNumber)
            elevator.changeState(new MoveUpState(elevator));
        else
            elevator.changeState(new MoveDownState(elevator));
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
