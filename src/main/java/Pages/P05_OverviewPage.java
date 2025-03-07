package Pages;

import Utilities.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class P05_OverviewPage {

    private final By nameitem2 = By.linkText("Sauce Labs Fleece Jacket");
    private final By nameitem1 = By.linkText("Sauce Labs Onesie");
    private final By finishbutton = By.id("finish");
    private final WebDriver driver;

    public P05_OverviewPage(WebDriver driver) {

        this.driver = driver;
    }

    public boolean Selecteditems() {
        if (driver.findElement(nameitem1).isDisplayed() && driver.findElement(nameitem2).isDisplayed()) {
            return true;
        }


        return true;
    }

    public P06_CompletePage clickonfinishbutton() {
        Utility.clickonElement(driver, finishbutton);
        return new P06_CompletePage(driver);
    }


}
