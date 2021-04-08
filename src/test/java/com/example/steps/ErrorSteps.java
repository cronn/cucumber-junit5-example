package com.example.steps;

import com.example.state.ScenarioState;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;

/**
 * Terminal steps that verify error conditions. The currently active example/scenario state is injected into an instance
 * of this class per example/scenario, thus you can share state across classes/steps.
 */
public class ErrorSteps {

  private final ScenarioState state;

  public ErrorSteps(final ScenarioState state) {
    this.state = state;
  }

  @When("some exception is thrown")
  public void exceptionIsThrown() {
    Assertions.assertThrows(NumberFormatException.class, () -> Integer.parseInt(state.getUserInput()));
  }

}
