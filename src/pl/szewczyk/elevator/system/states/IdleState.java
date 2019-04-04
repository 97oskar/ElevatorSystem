package pl.szewczyk.elevator.system.states;

import pl.szewczyk.elevator.system.*;

public class IdleState implements Stateful {
    private Elevator elevator;

    public IdleState(Elevator elevator) {
        this.elevator = elevator;
    }

    @Override
    public void takeStep() {
    }

    @Override
    public ElevatorStatus getStatus() {
        return new ElevatorStatus(elevator.getId(), elevator.getCurrentFloor(), null);
    }

}
