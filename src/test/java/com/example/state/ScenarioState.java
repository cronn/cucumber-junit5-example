package com.example.state;

/**
 * An instance of this class will be injected in each scenario, thus allowing all scenarios to be run in parallel.
 */
public class ScenarioState {

    private String userInput;
    private int result;

    public String getUserInput() {
        return userInput;
    }

    public void setUserInput(String userInput) {
        this.userInput = userInput;
    }

    public int getResult() {
        return result;
    }

    public void setResult(int result) {
        this.result = result;
    }

}
