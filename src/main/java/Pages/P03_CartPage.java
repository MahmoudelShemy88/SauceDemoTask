package Pages;

import Utilities.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class P03_CartPage {
    private final WebDriver driver;
    private final By nameitem2 = By.linkText("Sauce Labs Fleece Jacket");
    private final By priceitem1 = By.xpath("//button[@name='remove-sauce-labs-onesie']//preceding-sibling::div");
    private final By priceitem2 = By.xpath("//button[@name='remove-sauce-labs-fleece-jacket']//preceding-sibling::div");
    private final By nameitem1 = By.linkText("Sauce Labs Onesie");
    private final By checkoutButton = By.id("checkout");


    public P03_CartPage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean itemsisvisibleincart() {
        return driver.findElement(nameitem1).isDisplayed();


    }

    public boolean item2isvisibleincart() {
        return driver.findElement(nameitem2).isDisplayed();

    }

    public String priceofitem1() {
        String price = Utility.gettext(driver, priceitem1);
        price = String.valueOf(Float.parseFloat(price.replace("$", "")));
        return price;

    }

    public boolean checkprice1() {
        return priceofitem1().equals("7.99");
    }

    public String priceofitem2() {
        String price = Utility.gettext(driver, priceitem2);
        price = String.valueOf(Float.parseFloat(price.replace("$", "")));
        return price;

    }

    public boolean checkprice2() {
        return priceofitem2().equals("49.99");
    }

    public P04_CheckoutPage ClickonCheckoutbutton() {
        Utility.clickonElement(driver, checkoutButton);
        return new P04_CheckoutPage(driver);
    }

}
