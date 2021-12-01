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
import io.appium.java_client.android.nativekey.AndroidKey;
import net.bytebuddy.asm.Advice;
import org.openqa.selenium.Keys;
import org.testng.Assert;

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
}

