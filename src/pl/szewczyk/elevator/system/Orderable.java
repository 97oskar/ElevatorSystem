package pl.szewczyk.elevator.system;

public interface Orderable {
    public void execute(Elevator elevator);
    public void setState(Elevator elevator);
    public Integer getFloorNumber();
}
