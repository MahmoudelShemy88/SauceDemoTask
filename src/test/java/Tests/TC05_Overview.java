package Tests;

import Listeners.iInvokedMethodListenerClass;
import Listeners.iTestResultListenerClass;
import Pages.P01_LoginPage;
import Pages.P05_OverviewPage;
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
public class TC05_Overview {


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
                .ClickonCarticon()
                .ClickonCheckoutbutton()
                .fillingPage()
                .clickonContinuebutton();
        Assert.assertTrue(new P05_OverviewPage(getDriver()).Selecteditems());
    }


    @AfterMethod
    public void quit() {
        quitDriver();

    }
}
