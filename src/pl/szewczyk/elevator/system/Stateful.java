package pl.szewczyk.elevator.system;

public interface Stateful {
    public void move();
    public void receiveOrder(ElevatorOrder newOrder);
    public ElevatorStatus getStatus();
}
