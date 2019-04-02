package pl.szewczyk.elevator.system;

public class MoveUpState implements Stateful {
    private Elevator elevator;

    public MoveUpState(Elevator elevator) {
        this.elevator = elevator;
    }

    @Override
    public void move() {
        elevator.moveUp();

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
