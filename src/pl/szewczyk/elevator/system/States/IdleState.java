package pl.szewczyk.elevator.system.States;

import pl.szewczyk.elevator.system.Elevator;
import pl.szewczyk.elevator.system.ElevatorOrder;
import pl.szewczyk.elevator.system.ElevatorStatus;
import pl.szewczyk.elevator.system.Stateful;
import pl.szewczyk.elevator.system.States.MoveDownState;
import pl.szewczyk.elevator.system.States.MoveUpState;

public class IdleState implements Stateful {
    private Elevator elevator;

    public IdleState(Elevator elevator) {
        this.elevator = elevator;
    }

    @Override
    public void move() {
    }

    @Override
    public void receiveOrder(ElevatorOrder newOrder) {
        elevator.addOrder(newOrder);

        if (elevator.getStatus().getCurrentFloor() < newOrder.getTargetFloor())
            elevator.changeState(new MoveUpState(elevator));
        else
            elevator.changeState(new MoveDownState(elevator));
    }

    @Override
    public ElevatorStatus getStatus() {
        return new ElevatorStatus(elevator.getId(), elevator.getCurrentFloor(), null);
    }

}
