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

    public ElevatorStatus getStatus() {
        return state.getStatus();
    }

    public Orderable getCurrentCommand() {
        if (commands.isEmpty())
            return null;

        return commands.peek();
    }

    public void move() {
        state.move();
    }

    public void moveUp() {
        ++currentFloor;
    }

    public void moveDown() {
        --currentFloor;
    }

    public void changeState(Stateful newState) {
        this.state = newState;
    }

    public void receiveNewCommand(Orderable newCommand) {
        state.receiveCommand(newCommand);
        this.commands.addLast(newCommand);
    }

    public void removeCurrentCommand() {
        commands.pop();
    }

    public void updateState() {                                     //!!
        if(commands.isEmpty())
            changeState(new IdleState(this));
        else {
            commands.peek().setState(this);
        }
    }

    public Integer receiveTargetFloorFromInput() {
        System.out.println("[" + id + "] " + "You're on " + currentFloor + " floor. Choose target: ");
        return inputValidator.getInteger(currentFloor);
    }

}
