package com.quantum.steps;

import com.qmetry.qaf.automation.step.QAFTestStepProvider;
import com.qmetry.qaf.automation.ui.WebDriverTestBase;
import com.qmetry.qaf.automation.ui.webdriver.QAFExtendedWebElement;
import com.quantum.pages.AmazonPage;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.api.java.tr.Ama;

@QAFTestStepProvider
public class AmazonStepDef {

    @When("user selects \"(.*?)\" language preference")
    public void selectLanguagePreference(String language){
        new AmazonPage().selectLanguagePreference(language);
    }

    @And("user selects \"(.*?)\" option")
    public void userSelectsOption(String option){
      new AmazonPage().selectSignInOption(option);
    }

    @And("^enters \"(.*?)\" in the search box$")
    public void enterSearchItem(String item) throws InterruptedException {
        new AmazonPage().enterSearchItem(item);
    }
    @And("^user verifies \"(.*?)\" product is displayed$")
    public void clickSearch(String product){
        new AmazonPage().verifySearchResult(product);
    }

    @And("^User launches url \"(.*?)\" on browser$")
    public void launchUrl(String url){
        new AmazonPage().launchUrl(url);
    }

    @And("^user enters \"(.*?)\" in the search box on web$")
    public void enterSearchItemOnWeb(String item) throws InterruptedException {
        new AmazonPage().enterSearchItemOnWeb(item);
    }

    @And("^user verifies \"(.*?)\" product is displayed on web$")
    public void verifyWebSearchResult(String product){
        new AmazonPage().verifyWebSearchResult(product);
    }

    @And("^user clicks \"(.*?)\" product$")
    public void clickOnProduct(String productname){
        new AmazonPage().clickOnProduct(productname);
    }

    @And("^user enters \"(.*?)\" value as pincode$")
    public void enterPinCode(String pin){
        new AmazonPage().enterPincode(pin);
    }

    @And("^user clicks on \"(.*?)\" button$")
    public void clickBtn(String btnValue) throws Exception {
        new AmazonPage().clickElement(btnValue);
    }

    @And("^user validates the total cart value \"(.*?)\"$")
    public void validateText(String value){
        new AmazonPage().validateText(value);
    }
}

