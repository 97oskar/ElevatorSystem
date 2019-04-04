package pl.szewczyk.elevator.system;

public interface Orderable {
    public void execute(Elevator elevator);
    public void setElevatorState(Elevator elevator);
    public Integer getFloorNumber();
    public void setFloorNumber(Integer floorNumber);
}
