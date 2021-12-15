package com.quantum.pages;

import com.qmetry.qaf.automation.core.ConfigurationManager;
import com.qmetry.qaf.automation.ui.WebDriverBaseTestPage;
import com.qmetry.qaf.automation.ui.WebDriverTestBase;
import com.qmetry.qaf.automation.ui.annotations.FindBy;
import com.qmetry.qaf.automation.ui.api.PageLocator;
import com.qmetry.qaf.automation.ui.api.WebDriverTestPage;
import com.qmetry.qaf.automation.ui.webdriver.QAFExtendedWebDriver;
import com.qmetry.qaf.automation.ui.webdriver.QAFExtendedWebElement;
import com.qmetry.qaf.automation.util.PropertyUtil;
import com.quantum.utils.DriverUtils;
import cucumber.api.java.en.And;
import io.appium.java_client.MobileBy;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.nativekey.AndroidKey;
import net.bytebuddy.asm.Advice;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.touch.TouchActions;
import org.testng.Assert;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

public class AmazonPage extends WebDriverBaseTestPage<WebDriverTestPage> {

    @Override
    protected void openPage(PageLocator pageLocator, Object... objects) {

    }

    @FindBy(locator = "amazon.language")
    private QAFExtendedWebElement languagePreference;
    @FindBy(locator = "amazon.language.continue")
    private QAFExtendedWebElement languagePreferenceContinue;
    @FindBy(locator = "amazon.signin.option")
    private QAFExtendedWebElement signInOption;
    @FindBy(locator = "amazon.search.frame")
    private QAFExtendedWebElement searchBoxFrame;
    @FindBy(locator = "amazon.search.textbox")
    private QAFExtendedWebElement searchBox;
    @FindBy(locator = "amazon.web.search.box")
    private QAFExtendedWebElement webSearchBox;
    @FindBy(locator = "amazon.web.search.button")
    private QAFExtendedWebElement webSearchButton;
    @FindBy(locator = "amazon.cart.subtotal.value")
    private QAFExtendedWebElement cartSubtotalValue;
    @FindBy(locator = "amazon.icon.search")
    private QAFExtendedWebElement searchIcon;
    @FindBy(locator = "amazon.nav.next")
    private QAFExtendedWebElement nextBtn;
    @FindBy(locator = "amazon.icon.cart")
    private QAFExtendedWebElement cartIcon;


    PropertyUtil props = ConfigurationManager.getBundle();

    public void selectLanguagePreference(String language){
        QAFExtendedWebElement languagePref = new QAFExtendedWebElement(String.format(props.getString("amazon.language"), language));
        languagePref.click();
        languagePreferenceContinue.click();
    }

    public void selectSignInOption(String signInOptionValue){
        QAFExtendedWebElement signInOptionVal = new QAFExtendedWebElement(String.format(props.getString("amazon.signin.option"), signInOptionValue));
        signInOptionVal.click();
    }
    public void enterSearchItem(String item) throws InterruptedException {
        searchBoxFrame.click();
        searchBox.sendKeys(item);
        Map<String,Object> key= new HashMap<String,Object>();
        key.put("key","66");
        driver.executeScript("mobile:key:event",key);
    }
    public void verifySearchResult(String productName){
        QAFExtendedWebElement product = new QAFExtendedWebElement(String.format(props.getString("amazon.search.results"), productName));
        Assert.assertTrue(product.isDisplayed());
    }

    public void launchUrl(String url){
        new WebDriverTestBase().getDriver().get(url);
    }

    public void enterSearchItemOnWeb(String str) throws InterruptedException {
        webSearchBox.click();
        webSearchBox.sendKeys(str);
        webSearchButton.click();
        Thread.sleep(10000);
    }

    public void verifyWebSearchResult(String productName){
        QAFExtendedWebElement product = new QAFExtendedWebElement(String.format(props.getString("amazon.web.search.results"), productName));
        Assert.assertTrue(product.isDisplayed());
    }

    public void selectPincodeOption(String pincodeOption){
        QAFExtendedWebElement product = new QAFExtendedWebElement(String.format(props.getString("amazon.pincode.option.button"), pincodeOption));
        product.click();
    }

    public void clickElement(String productname){
        QAFExtendedWebElement product = new QAFExtendedWebElement(String.format(props.getString("amazon.search.results"), productname));
        product.click();
    }

    public void enterPincode(String pinvalue){
        QAFExtendedWebElement pin = new QAFExtendedWebElement(String.format(props.getString("amazon.pincode.textbox"), pinvalue));
        //pin.click();
        pin.sendKeys(pinvalue);
        Map<String,Object> key= new HashMap<String,Object>();
        key.put("key","66");
        driver.executeScript("mobile:key:event",key);
    }

    /*public void clickElement(String elementText) throws Exception {
        boolean flag = true;
        int maxCheck = 5;
        while(flag){
            try {
                Map<String, Object> params = new HashMap<>();
                params.put("content",elementText);
                String result = (String)DriverUtils.getDriver().executeScript("mobile:text:find",params);
                if(result.equals("true")){
                    flag = false;
                    break;
                }
                else throw new Exception();
            }
            catch (Exception NoSuchElementException){
                maxCheck--;
                Map<String, Object> params = new HashMap<>();
                params.put("start", "40%,60%");
                params.put("end", "40%,20%");
                params.put("duration", "2");
                Object res = DriverUtils.getDriver().executeScript("mobile:touch:swipe", params);
                if(maxCheck==0){
                    break;
                }
            }
        }
        QAFExtendedWebElement btn = new QAFExtendedWebElement(String.format(props.getString("amazon.button"), elementText));
        btn.click();
    }*/

    public void validateText(String value){
        String stValue = cartSubtotalValue.getText();
        if (!stValue.contains(value)){
            Assert.fail("Subtotal does not matches the expected value : " + stValue);
        }
    }

    public void clickSearchIcon(){
        searchIcon.click();
    }

    public void clickCartIcon(){
        cartIcon.click();
    }

    public void clickOnProduct(String elementText) throws Exception {
        boolean flag = true;
        while (flag) {
            try {
                Map<String, Object> params = new HashMap<>();
                params.put("content", elementText);
                String result = (String) DriverUtils.getDriver().executeScript("mobile:text:find", params);
                if (result.equals("true")) {
                    flag = false;
                    break;
                } else throw new Exception();
            } catch (Exception NoSuchElementException) {

                //check for next button
                try{
                    if (nextBtn.isDisplayed()) {
                        if (nextBtn.isEnabled()) {
                            nextBtn.click();
                        }
                    }
                }
                catch(Exception e) {
                        Map<String, Object> params = new HashMap<>();
                        params.put("start", "40%,60%");
                        params.put("end", "40%,20%");
                        params.put("duration", "2");
                        Object res = DriverUtils.getDriver().executeScript("mobile:touch:swipe", params);
                    }
                }
            }
            QAFExtendedWebElement btn = new QAFExtendedWebElement(String.format(props.getString("amazon.button"), elementText));
            btn.click();
        }
}
