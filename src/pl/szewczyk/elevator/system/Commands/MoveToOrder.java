package pl.szewczyk.elevator.system.Commands;

import pl.szewczyk.elevator.system.Elevator;
import pl.szewczyk.elevator.system.Orderable;
import pl.szewczyk.elevator.system.States.MoveDownState;
import pl.szewczyk.elevator.system.States.MoveUpState;
import pl.szewczyk.elevator.system.States.ReceiveOrderState;

public class MoveToOrder implements Orderable {
    private Integer floorNumber;
    private Orderable receiveOrderCommand;


    public MoveToOrder(Integer floorNumber, Orderable receiveOrderCommand) {
        this.floorNumber = floorNumber;
        this.receiveOrderCommand = receiveOrderCommand;
    }

    @Override
    public void execute(Elevator elevator) {
        elevator.removeExecutedCommand();
        elevator.addCommandAsFirst(receiveOrderCommand);
        elevator.updateState();
    }

    @Override
    public void setState(Elevator elevator) {                           //TO DO
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
