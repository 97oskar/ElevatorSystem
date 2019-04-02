package pl.szewczyk.elevator.system;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;


public class Elevator {
    private Integer id;
    private Integer currentFloor;
    private Stateful state;
    private Deque<ElevatorOrder> orders = new LinkedList<ElevatorOrder>();

    public Elevator(int Id, int initialFloor) {
        this.id = Id;
        this.currentFloor = initialFloor;
    }

    public ElevatorStatus getStatus() {
        if (orders.isEmpty())
            return new ElevatorStatus(this.id, this.currentFloor, null);
        else
            return new ElevatorStatus(this.id, this.currentFloor, this.orders.peek().getTargetFloor());
    }

    public void move() {
        if (!orders.isEmpty()) {
            if (isTargetFloorReached()) {
                if (orders.peek().isFinalFloorChoosen())
                    orders.remove();
                else
                    orders.peek().setFinalFloor(getTargetFloor());
            } else {
                if (currentFloor > this.orders.peek().getTargetFloor()) {
                    this.currentFloor--;
                } else {
                    this.currentFloor++;
                }
            }
        }
    }

    private boolean isTargetFloorReached() {
        return orders.peek().getTargetFloor().equals(currentFloor);
    }

    public void addOrder(ElevatorOrder newOrder) {
        this.orders.addLast(newOrder);
    }

    public void updateState(Integer currentFloor, Integer targetFloor) {
        this.currentFloor = currentFloor;
        this.orders.addFirst(new ElevatorOrder(targetFloor, true));
    }

    public Integer getTargetFloor() {
        Scanner scan = new Scanner(System.in);
        System.out.println("[" + id + "] " + "You're on " + currentFloor + " floor. Choose target: ");
        int targetFloor = scan.nextInt();

        return targetFloor;
    }
}
