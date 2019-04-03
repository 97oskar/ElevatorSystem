package pl.szewczyk.elevator.system;

public interface Orderable {
    public void execute(Elevator elevator);
    public Integer getFloorNumber();
}
