package com.quantum.pages;

import com.qmetry.qaf.automation.core.ConfigurationManager;
import com.qmetry.qaf.automation.ui.WebDriverBaseTestPage;
import com.qmetry.qaf.automation.ui.annotations.FindBy;
import com.qmetry.qaf.automation.ui.api.PageLocator;
import com.qmetry.qaf.automation.ui.api.WebDriverTestPage;
import com.qmetry.qaf.automation.ui.webdriver.QAFExtendedWebElement;
import com.qmetry.qaf.automation.util.PropertyUtil;
import org.testng.Assert;

public class CalculatorPage extends WebDriverBaseTestPage<WebDriverTestPage> {
    @Override
    protected void openPage(PageLocator pageLocator, Object... objects) {

    }
    PropertyUtil props = ConfigurationManager.getBundle();

    @FindBy(locator = "calculator.result")
    private QAFExtendedWebElement result;


    public void clickButton(String value){
        QAFExtendedWebElement buttonValue = new QAFExtendedWebElement(String.format(props.getString("calculator.value"), value));
        buttonValue.click();
    }

    public void verifyResult(String resultValue){
        String res = result.getText();
        Assert.assertEquals(res,resultValue);
    }

}
