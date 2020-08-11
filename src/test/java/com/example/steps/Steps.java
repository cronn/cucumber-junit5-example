package com.example.steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Steps {

    @Given("something exists")
    @Given("something else exists")
    public void setup() {
        // execute steps
    }

    @When("something is executed")
    public void execute() {
        // execute steps
    }

    @When("some exception is thrown")
    public void exceptionIsThrown() {
        // execute steps
    }

    @Then("some result will be calculated")
    @Then("no result can be calculated")
    public void result() {
        // execute steps
    }

}
