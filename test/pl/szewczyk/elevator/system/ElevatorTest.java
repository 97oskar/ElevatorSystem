package pl.szewczyk.elevator.system;

import org.junit.jupiter.api.BeforeEach;

class ElevatorTest {
    Elevator elevator;

    @BeforeEach
    void setUp() {
        elevator = new Elevator(5, 2);
    }
}