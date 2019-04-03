package pl.szewczyk.elevator.system;

public interface Stateful {
    public void move();
    public void receiveCommand(Orderable newCommand);
    public ElevatorStatus getStatus();
}
