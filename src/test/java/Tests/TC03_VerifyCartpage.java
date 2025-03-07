package Tests;

import Listeners.iInvokedMethodListenerClass;
import Listeners.iTestResultListenerClass;
import Pages.P01_LoginPage;
import Pages.P03_CartPage;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.io.IOException;
import java.time.Duration;

import static DriverFactory.DriverFactory.*;
import static Utilities.DataUtils.getJsonData;
import static Utilities.DataUtils.getPropertyByValue;

@Listeners({iInvokedMethodListenerClass.class, iTestResultListenerClass.class})
public class TC03_VerifyCartpage {

    @BeforeMethod

    public void setup() throws IOException {
        setupDriver(getPropertyByValue("environments", "BROWSER"));
        getDriver().get(getPropertyByValue("environments", "BASE_URL"));
        getDriver().manage().timeouts()
                .implicitlyWait(Duration.ofSeconds(15L));
    }


    @Test //case to verify the Selected items and prices
    public void VerifycartitemsandPrices() throws IOException {
        new P01_LoginPage(getDriver())
                .enterUsername(getJsonData("validLogin", "username"))
                .enterpassword(getJsonData("validLogin", "password"))
                .clickonLogButton()
                .addtocart()
                .NavtoDetailsandadditem()
                .ClickonCarticon();
        Assert.assertTrue(new P03_CartPage(getDriver()).itemsisvisibleincart());
        Assert.assertTrue(new P03_CartPage(getDriver()).item2isvisibleincart());
        Assert.assertTrue(new P03_CartPage(getDriver()).checkprice1());
        Assert.assertTrue(new P03_CartPage(getDriver()).checkprice2());


    }


    @AfterMethod
    public void quit() {
        quitDriver();

    }


}
