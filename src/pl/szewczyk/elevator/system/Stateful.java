package pl.szewczyk.elevator.system;

public interface Stateful {
    public void takeStep();
    public ElevatorStatus getStatus();
}
