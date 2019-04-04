package pl.szewczyk.elevator.system;

import pl.szewczyk.elevator.system.States.IdleState;

import java.util.Deque;
import java.util.LinkedList;


public class Elevator {
    private Integer id;
    private Integer currentFloor;
    private InputValidator inputValidator;
    private Stateful state;
    private Deque<Orderable> commands = new LinkedList<Orderable>();

    public Elevator(int Id, int initialFloor, int numberOfFloors) {
        this.id = Id;
        this.currentFloor = initialFloor;
        this.inputValidator = new InputValidator(numberOfFloors);
        this.state = new IdleState(this);
    }

    public Integer getId() {
        return id;
    }

    public Integer getCurrentFloor() {
        return currentFloor;
    }

    public Orderable getCurrentCommand() {
        return commands.peek();
    }

    public ElevatorStatus getStatus() {
        return state.getStatus();
    }

    public void takeStep() {
        state.takeStep();
    }

    public void moveUp() {
        ++currentFloor;
    }

    public void moveDown() {
        --currentFloor;
    }

    public void receiveNewCommand(Orderable command) {
        command.execute(this);
        updateState();
    }

    public void addCommandAsFirst(Orderable command) {
        this.commands.addFirst(command);
    }

    public void addCommandAsLast(Orderable command) {
        this.commands.addLast(command);
    }

    public void removeExecutedCommand() {
        commands.pop();
    }

    public void changeState(Stateful newState) {
        this.state = newState;
    }

    public void updateState() {                    
        if(commands.isEmpty())
            changeState(new IdleState(this));
        else {
            commands.peek().setElevatorState(this);
        }
    }

    public Integer receiveTargetFloorFromInput() {
        System.out.println("\n[" + id + "] " + "You're on " + currentFloor + " floor. Choose target: ");
        return inputValidator.getInteger(currentFloor);
    }

}
