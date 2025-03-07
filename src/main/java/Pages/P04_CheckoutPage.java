package Pages;

import Utilities.Utility;
import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class P04_CheckoutPage {


    private final WebDriver driver;

    private final By firstname = By.id("first-name");
    private final By lastname = By.id("last-name");
    private final By zipcode = By.id("postal-code");
    private final By Continuebutton = By.id("continue");
    Faker faker = new Faker();
    public String Randomfirstname = faker.name().firstName();
    public String Randomlastname = faker.name().lastName();
    public String RandomZipcode = faker.address().zipCode();

    public P04_CheckoutPage(WebDriver driver) {
        this.driver = driver;
    }

    public P04_CheckoutPage fillingPage() {
        Utility.senddata(driver, firstname, Randomfirstname);
        Utility.senddata(driver, lastname, Randomlastname);
        Utility.senddata(driver, zipcode, RandomZipcode);
        return this;

    }

    public P05_OverviewPage clickonContinuebutton() {
        Utility.clickonElement(driver, Continuebutton);
        return new P05_OverviewPage(driver);
    }


}
