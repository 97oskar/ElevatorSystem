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
        InputValidator.setMaximumNumber(3);
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
    void shouldTargetFloorBeEqualTo0WhenElevatorOrderedTo0() {
        elevatorSystem.pickUp(0, 1);
        assertEquals(0, elevatorSystem.status().get(0).getTargetFloor());
    }

    @Test
    void shouldTargetFloorBeMaximumFloorNumberWhenElevatorOrderedAboveRange() {
        elevatorSystem.pickUp(5, -1);
        assertEquals(3, elevatorSystem.status().get(0).getTargetFloor());
    }

    @Test
    void shouldTargetFloorBe0WhenElevatorOrderedBelowRange() {
        elevatorSystem.pickUp(-1, 1);
        assertEquals(0, elevatorSystem.status().get(0).getTargetFloor());
    }
}