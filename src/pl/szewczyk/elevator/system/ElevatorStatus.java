package pl.szewczyk.elevator.system;

public class ElevatorStatus {
    private Integer elevatorID;
    private Integer currentFloor;
    private Integer targetFloor;

    public ElevatorStatus(Integer elevatorID, Integer currentFloor, Integer targetFloor) {
        this.elevatorID = elevatorID;
        this.currentFloor = currentFloor;
        this.targetFloor = targetFloor;
    }

    public String toString() {
        return "[" + elevatorID + "] | " + currentFloor + " | " + " | " + targetFloor + " |";
    }
}
