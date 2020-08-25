package com.example.steps;

import com.example.state.ScenarioState;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;

public class ErrorSteps {

    private final ScenarioState state;

    public ErrorSteps(ScenarioState state) {
        this.state = state;
    }

    @When("some exception is thrown")
    public void exceptionIsThrown() {
        Assertions.assertThrows(NumberFormatException.class, () -> Integer.parseInt(state.getUserInput()));
    }

}
