package pl.szewczyk.elevator.system;

public interface Stateful {
    public void move();
    public void receiveCommand(Orderable newOrder);
    public ElevatorStatus getStatus();
}
