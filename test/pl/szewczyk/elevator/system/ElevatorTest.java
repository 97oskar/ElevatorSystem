package pl.szewczyk.elevator.system;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pl.szewczyk.elevator.system.commands.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ElevatorTest {
    Elevator elevator;

    @BeforeEach
    void setUp() {
        elevator = new Elevator(5, 2);
    }

    @Test
    void shouldElevatorMoveUpIfTargetFloorIsAboveCurrent() {
        int startingFloor = elevator.getCurrentFloor();
        elevator.receiveNewCommand(new SetCommandAsFirst(new MoveToTarget(5)));
        elevator.takeStep();

        assertEquals(true, startingFloor < elevator.getCurrentFloor());
    }

    @Test
    void shouldElevatorMoveDownIfTargetFloorIsBelowCurrent() {
        int startingFloor = elevator.getCurrentFloor();
        elevator.receiveNewCommand(new SetCommandAsLast(new MoveToTarget(0)));
        elevator.takeStep();

        assertEquals(true, startingFloor > elevator.getCurrentFloor());
    }

    @Test
    void shouldElevatorNotMoveIfTargetFloorIsSameAsCurrent() {
        Integer startingFloor = elevator.getCurrentFloor();
        elevator.receiveNewCommand(new SetCommandAsFirst(new MoveToTarget(2)));
        elevator.takeStep();

        assertEquals(true, startingFloor.equals(elevator.getCurrentFloor()));
    }

    @Test
    void shouldElevatorNotMoveIfTargetFloorIsNull() {
        Integer startingFloor = elevator.getCurrentFloor();
        elevator.takeStep();
        elevator.takeStep();

        assertEquals(true, startingFloor.equals(elevator.getCurrentFloor()));
    }

    @Test
    void shouldNextDirectionBeUpIfCommandIsMoveToOrderWithUpDirection() {
        elevator.receiveNewCommand(new SetCommandAsLast(new MoveToOrder(3, 1,
                                   new SetCommandAsFirst(new ReceiveOrder(1, new SetTargetAsFirst())))));

        assertEquals(1, elevator.getNextDirection());
    }

    @Test
    void shouldDirectionBeDownIfCommandIsMoveToOrderWithDownDirection() {
        elevator.receiveNewCommand(new SetCommandAsFirst(new MoveToOrder(1, -1,
                new SetCommandAsLast(new ReceiveOrder(1, new SetTargetAsLast())))));

        assertEquals(-1, elevator.getNextDirection());
    }

    @Test
    void shouldDirectionBeNullIfCommandIsMoveToTarget() {
        elevator.receiveNewCommand(new SetCommandAsFirst(new MoveToTarget(4)));

        assertEquals(null, elevator.getNextDirection());
    }

    @Test
    void shouldDirectionBeNullIfCommandIsReceiveOrder() {
        elevator.receiveNewCommand(new SetCommandAsFirst(new ReceiveOrder(2, new SetTargetAsFirst())));

        assertEquals(null, elevator.getNextDirection());
    }
}