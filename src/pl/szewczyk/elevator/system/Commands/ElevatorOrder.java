package pl.szewczyk.elevator.system.Commands;


import pl.szewczyk.elevator.system.Elevator;
import pl.szewczyk.elevator.system.Orderable;

public class ElevatorOrder implements Orderable {
    private Integer floorNumber;
    private Integer direction;

    public ElevatorOrder(Integer floorNumber, Integer direction) {
        this.floorNumber = floorNumber;
        this.direction = direction;
    }

    @Override
    public void execute(Elevator elevator) {
        elevator.removeCurrentOrder();
        Integer targetFloor = elevator.receiveTargetFloorFromInput();
        elevator.receiveOrder(new GoToFinalFloor(targetFloor));
    }

    @Override
    public Integer getFloorNumber() {
        return floorNumber;
    }
}
