package pl.szewczyk.elevator.system;

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

    public ElevatorOrder getCurrentOrder() {
        if(orders.isEmpty())
            return null;

        return orders.peek();
    }

    private Integer id;
    private Integer currentFloor;
    private Stateful state;
    private Deque<ElevatorOrder> orders = new LinkedList<ElevatorOrder>();

    public Elevator(int Id, int initialFloor) {
        this.id = Id;
        this.currentFloor = initialFloor;
        this.state = new IdleState(this);
    }

    public ElevatorStatus getStatus() {
        return state.getStatus();
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

    private boolean isTargetFloorReached() {
        return orders.peek().getTargetFloor().equals(currentFloor);
    }

    public void receiveOrder(ElevatorOrder newOrder) {
        state.receiveOrder(newOrder);
    }

    public void addOrder(ElevatorOrder newOrder) {
        this.orders.addLast(newOrder);
    }

    public void updateState(Integer currentFloor, Integer targetFloor) {
        this.currentFloor = currentFloor;
        this.orders.addFirst(new ElevatorOrder(targetFloor, true));
    }

    public Integer receiveTargetFloorFromInput() {
        Scanner scan = new Scanner(System.in);
        System.out.println("[" + id + "] " + "You're on " + currentFloor + " floor. Choose target: ");
        int targetFloor = scan.nextInt();

        return targetFloor;
    }

    public void removeCurrentOrder() {
        orders.pop();

        adjustStateToNextStep();
    }

    private void adjustStateToNextStep() {
        if(orders.isEmpty())
            changeState(new IdleState(this));
        else if(currentFloor < orders.peek().getTargetFloor())
            changeState(new MoveUpState(this));
        else
            changeState(new MoveDownState(this));
    }
}
