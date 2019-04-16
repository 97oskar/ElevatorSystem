package pl.szewczyk.elevator.system;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pl.szewczyk.elevator.system.distribution.algorithms.RandomDistributor;

import static org.junit.jupiter.api.Assertions.*;

class ElevatorSystemTest {
    ElevatorSystem elevatorSystem;

    @BeforeEach
    void setUp() {
        elevatorSystem = new ElevatorSystem(1, 3, new RandomDistributor());
    }

    @Test
    void shouldArrayOfElevatorStatusesNotBeEmpty() {
        assertFalse(elevatorSystem.status().isEmpty());
    }

    @Test
    void shouldArrayOfElevatorStatusesLengthBeEqualTo1() {
        assertEquals(1, elevatorSystem.status().size());
    }

    @Test
    void shouldTargetFloorBeEqualTo2WhenElevatorOrderedTo2() {
        elevatorSystem.pickUp(2, 1);
        assertEquals(2, elevatorSystem.status().get(0).getTargetFloor());
    }

    @Test
    void shoultTargetFloorBeEqualtT0WhenElevatorOrderdTo0() {
        elevatorSystem.pickUp(0, 1);
        assertEquals(0, elevatorSystem.status().get(0).getTargetFloor());
    }

    @Test
    void shouldTargetFloorBeNullWhenElevatorOrderedAboveRange() {
        elevatorSystem.pickUp(5, -1);
        assertNull(elevatorSystem.status().get(0).getTargetFloor());
    }

    @Test
    void shouldTargetFloorBeNullWhenElevatorOrderedBelowRange() {
        elevatorSystem.pickUp(-1, 1);
        assertNull(elevatorSystem.status().get(0).getTargetFloor());
    }
}