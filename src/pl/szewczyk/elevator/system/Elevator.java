package pl.szewczyk.elevator.system;

import pl.szewczyk.elevator.system.States.IdleState;
import pl.szewczyk.elevator.system.States.MoveDownState;
import pl.szewczyk.elevator.system.States.MoveUpState;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;


public class Elevator {
    public Integer getId() {
        return id;
    }

    public Integer getCurrentFloor() {
        return currentFloor;
    }

    public Orderable getCurrentCommand() {
        if (commands.isEmpty())
            return null;

        return commands.peek();
    }

    public ElevatorStatus getStatus() {
        return state.getStatus();
    }

    private Integer id;
    private Integer currentFloor;
    private Stateful state;

    private Deque<Orderable> commands = new LinkedList<Orderable>();

    public Elevator(int Id, int initialFloor) {
        this.id = Id;
        this.currentFloor = initialFloor;
        this.state = new IdleState(this);
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

    public void receiveOrder(Orderable newOrder) {
        state.receiveOrder(newOrder);
        this.commands.addLast(newOrder);
    }

    public void removeCurrentOrder() {                  //!!!
        commands.pop();
        adjustStateToNextStep();
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

    private void adjustStateToNextStep() {
        if (commands.isEmpty())
            changeState(new IdleState(this));
        else if (currentFloor < commands.peek().getFloorNumber())
            changeState(new MoveUpState(this));
        else
            changeState(new MoveDownState(this));
    }
}
