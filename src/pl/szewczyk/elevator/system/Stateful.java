package pl.szewczyk.elevator.system;

public interface Stateful {
    public void takeStep();
    public void receiveNewCommand(Orderable newCommand);
    public ElevatorStatus getStatus();
}
