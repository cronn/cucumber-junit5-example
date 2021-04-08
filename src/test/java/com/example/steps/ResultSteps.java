package com.example.steps;

import com.example.state.ScenarioState;
import io.cucumber.java.en.Then;
import org.junit.jupiter.api.Assertions;

/**
 * Terminal steps that verify success conditions. The currently active example/scenario state is injected into an
 * instance of this class per example/scenario, thus you can share state across classes/steps.
 */
public class ResultSteps {

  private final ScenarioState state;

  public ResultSteps(final ScenarioState state) {
    this.state = state;
  }

  @Then("some result will be calculated")
  public void result() {
    Assertions.assertTrue(state.getResult() > 0);
  }

  @Then("no result can be calculated")
  public void noResult() {
    Assertions.assertFalse(state.getResult() > 0);
  }

}
