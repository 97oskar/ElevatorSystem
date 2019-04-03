package pl.szewczyk.elevator.system.States;

import pl.szewczyk.elevator.system.Elevator;
import pl.szewczyk.elevator.system.ElevatorOrder;
import pl.szewczyk.elevator.system.ElevatorStatus;
import pl.szewczyk.elevator.system.Stateful;

public class MoveDownState implements Stateful {
    private Elevator elevator;

    public MoveDownState(Elevator elevator) {
        this.elevator = elevator;
    }

    @Override
    public void move() {                            //!!!
        elevator.moveDown();

        if(isTargetFloorReached()) {
            if(elevator.getCurrentOrder().isFinalFloorChoosen()) {
                elevator.removeCurrentOrder();
            }
            else
                elevator.getCurrentOrder().setFinalFloor(elevator.receiveTargetFloorFromInput());
        }
    }

    @Override
    public void receiveOrder(ElevatorOrder newOrder) {
        elevator.addOrder(newOrder);
    }

    @Override
    public ElevatorStatus getStatus() {
        return new ElevatorStatus(elevator.getId(), elevator.getCurrentFloor(), elevator.getCurrentOrder().getTargetFloor());
    }

    private boolean isTargetFloorReached() {
        return elevator.getCurrentFloor().equals(elevator.getCurrentOrder().getTargetFloor());
    }
}
