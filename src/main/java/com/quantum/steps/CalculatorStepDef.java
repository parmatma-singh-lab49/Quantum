package com.quantum.steps;

import com.qmetry.qaf.automation.step.QAFTestStepProvider;
import com.quantum.pages.CalculatorPage;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

@QAFTestStepProvider
public class CalculatorStepDef {

    @Given("user clicks on \"(.*?)\"")
    public void clickButton(String value){
        new CalculatorPage().clickButton(value);
    }

    @Then("user verifies the result \"(.*?)\"")
    public void verifyResult(String resultValue){
        new CalculatorPage().verifyResult(resultValue);
    }
}
