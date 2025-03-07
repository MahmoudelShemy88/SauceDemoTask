package Pages;

import Utilities.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class P01_LoginPage {
    private final By username = By.id("user-name");
    private final By password = By.id("password");
    private final By Loginbutton = By.id("login-button");

    private final WebDriver driver;


    public P01_LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public P01_LoginPage enterUsername(String usernameText) {
        Utility.senddata(driver, username, usernameText);
        return this;
    }

    public P01_LoginPage enterpassword(String pass) {
        Utility.senddata(driver, password, pass);
        return this;
    }


    public P02_LandingPage clickonLogButton() {
        Utility.clickonElement(driver, Loginbutton);
        return new P02_LandingPage(driver);
    }

    public boolean assertloginTC(String expectedvalue) {
        return driver.getCurrentUrl().equals(expectedvalue);
    }
}
