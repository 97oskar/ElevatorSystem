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
        elevator.removeCurrentCommand();
        Integer targetFloor = elevator.receiveTargetFloorFromInput();
        elevator.receiveCommand(new GoToFinalFloor(targetFloor));
        elevator.updateState();
    }

    @Override
    public void setState(Elevator elevator) {

    }

    @Override
    public Integer getFloorNumber() {
        return floorNumber;
    }
}
