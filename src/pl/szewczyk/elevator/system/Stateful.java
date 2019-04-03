package pl.szewczyk.elevator.system;

public interface Stateful {
    public void move();
    public void receiveOrder(Orderable newOrder);
    public ElevatorStatus getStatus();
}
