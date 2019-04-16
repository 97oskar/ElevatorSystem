package pl.szewczyk.elevator.system;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class InputValidatorTest {

    @BeforeEach
    void setUp() {
        InputValidator.setMaximumNumber(10);
    }

    @Test
    void shouldPickUpCommandStringBeValid() {

    }

    @Test
    void shouldPickUpCommandStringNotBeValid() {

    }

    @Test
    void shouldDirectionValidatorReturn1() {

    }

    @Test
    void shouldDirectionValidatorReturn0() {

    }

    @Test
    void shouldDirectionValidatorReturnMinus1() {

    }

    @Test
    void shouldFloorNumberValidatorReturn4() {

    }

    @Test
    void shouldFloorNumberValidatorReturnMaximumValueWhenValueAboveRange() {

    }

    @Test
    void shouldFloorNumberValidatorReturn0WhenValueBelowRange() {

    }
}