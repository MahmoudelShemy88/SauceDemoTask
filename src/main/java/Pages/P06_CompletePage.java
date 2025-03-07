package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class P06_CompletePage {


    private final WebDriver driver;
    private final By Thanksmsg = By.tagName("h2");

    public P06_CompletePage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean checkVisiablityofThanks() {
        return driver.findElement(Thanksmsg).isDisplayed();
    }
}
