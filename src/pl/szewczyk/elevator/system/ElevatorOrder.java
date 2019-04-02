package pl.szewczyk.elevator.system;


public class ElevatorOrder {
    private Integer targetFloor;
    private Integer direction;
    private boolean isFinalFloorChoosen;

    ElevatorOrder(Integer targetFloor, boolean isFinalFloorChoosen) {
        this.targetFloor = targetFloor;
        this.isFinalFloorChoosen = isFinalFloorChoosen;
    }

    public ElevatorOrder(Integer targetFloor, Integer direction) {
        this.targetFloor = targetFloor;
        this.direction = direction;
        this.isFinalFloorChoosen = false;
    }

    public boolean isFinalFloorChoosen() {
        return isFinalFloorChoosen;
    }

    public Integer getTargetFloor() {
        return targetFloor;
    }

    public void setFinalFloor(Integer finalFloor) {
        this.targetFloor = finalFloor;
        this.isFinalFloorChoosen = true;
    }
}
