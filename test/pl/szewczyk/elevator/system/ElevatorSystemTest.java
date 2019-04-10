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
    void arrayOfElevatorStatusesShouldBeNotEmpty() {
        assertFalse(elevatorSystem.status().isEmpty());
    }

    @Test
    void lengthShouldBeEqualTo1() {
        assertEquals(1, elevatorSystem.status().size());
    }

    @Test
    void targetFloorShouldBeEqualTo2() {
        elevatorSystem.pickUp(2, 1);
        assertEquals(2, elevatorSystem.status().get(0).getTargetFloor());
    }

    @Test
    void targetFloorShouldBeEqualtTo3() {
        elevatorSystem.pickUp(3, -1);
        assertEquals(3, elevatorSystem.status().get(0).getTargetFloor());
    }

    @Test
    void targetFloorShouldBeNull() {
        elevatorSystem.pickUp(5, -1);
        assertNull(elevatorSystem.status().get(0).getTargetFloor());
    }

    @Test
    void tagetFloorShouldBeNull() {
        elevatorSystem.pickUp(-1, 1);
        assertNull(elevatorSystem.status().get(0).getTargetFloor());
    }
}