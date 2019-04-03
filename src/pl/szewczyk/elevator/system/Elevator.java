package pl.szewczyk.elevator.system;

import pl.szewczyk.elevator.system.States.IdleState;
import pl.szewczyk.elevator.system.States.MoveDownState;
import pl.szewczyk.elevator.system.States.MoveUpState;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;


public class Elevator {
    private Integer id;
    private Integer currentFloor;
    private Stateful state;
    private Deque<Orderable> commands = new LinkedList<Orderable>();

    public Elevator(int Id, int initialFloor) {
        this.id = Id;
        this.currentFloor = initialFloor;
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
        currentFloor++;
    }

    public void moveDown() {
        currentFloor--;
    }

    public void changeState(Stateful newState) {
        this.state = newState;
    }

    public void receiveCommand(Orderable newOrder) {
        state.receiveCommand(newOrder);
        this.commands.addLast(newOrder);
    }

    public void removeCurrentCommand() {
        commands.pop();
    }

    public void updateState() {
        if(commands.isEmpty())
            changeState(new IdleState(this));
        else {
            commands.peek().setState(this);
        }
    }

    public void updateState(Integer currentFloor, Integer targetFloor) {      //TO DO
//        this.currentFloor = currentFloor;
//        this.Commands.addFirst(new ElevatorOrder(targetFloor, true));
    }

    public Integer receiveTargetFloorFromInput() {
        Scanner scan = new Scanner(System.in);
        System.out.println("[" + id + "] " + "You're on " + currentFloor + " floor. Choose target: ");
        int targetFloor = scan.nextInt();

        return targetFloor;
    }

}
