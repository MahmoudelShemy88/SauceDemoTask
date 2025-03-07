package Tests;

import Listeners.iInvokedMethodListenerClass;
import Listeners.iTestResultListenerClass;
import Pages.P01_LoginPage;
import Utilities.LogsUtils;
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
public class TC01_LoginTest {
    @BeforeMethod

    public void setup() throws IOException {
        setupDriver(getPropertyByValue("environments", "BROWSER"));
        LogsUtils.info("Edge driver is opened");
        getDriver().get(getPropertyByValue("environments", "BASE_URL"));
        LogsUtils.info("Page is Redirect to URL");
        getDriver().manage().timeouts()
                .implicitlyWait(Duration.ofSeconds(15L));
    }


    @Test // case to verify login and current URL we are in
    public void validLoginTC() throws IOException {
        new P01_LoginPage(getDriver())
                .enterUsername(getJsonData("validLogin", "username"))
                .enterpassword(getJsonData("validLogin", "password"))
                .clickonLogButton();
        Assert.assertTrue(new P01_LoginPage(getDriver()).assertloginTC(getPropertyByValue("environments", "HOME_URL")));

    }


    @AfterMethod
    public void quit() {
        quitDriver();

    }


}
