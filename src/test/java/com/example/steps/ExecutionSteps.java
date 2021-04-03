package com.example.steps;

import com.example.state.ScenarioState;
import io.cucumber.java.en.When;

/**
 * State modifying steps. They act on the currently active scenario state which is inject into an instance of this class
 * per scenario.
 */
public class ExecutionSteps {

    private final ScenarioState state;

    public ExecutionSteps(final ScenarioState state) {
        this.state = state;
    }

    @When("something is executed")
    public void execute() {
        final var userInput = state.getUserInput();
        final var result = Integer.parseInt(userInput);
        state.setResult(result);
    }

}
