package Pages;

import Utilities.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class P02_LandingPage {
    public static List<WebElement> allproducts;
    private final WebDriver driver;
    private final By addtocart = By.id("add-to-cart-sauce-labs-fleece-jacket");
    private final By Gotoitem2 = By.linkText("Sauce Labs Onesie");
    private final By additem2 = By.xpath("//button[@name='add-to-cart']");
    private final By cartnumber = By.className("shopping_cart_badge");
    private final By priceofjacket = By.xpath("//button[@data-test='add-to-cart-sauce-labs-fleece-jacket']//preceding-sibling::div");
    private final By Carticon = By.className("shopping_cart_link");
    private final By nameofitem1 = By.linkText("Sauce Labs Fleece Jacket");

    public P02_LandingPage(WebDriver driver) {

        this.driver = driver;
    }


    public By getNumberofSelectedProductsincart() {
        return cartnumber;
    }

    public P02_LandingPage addtocart() {
        Utility.clickonElement(driver, addtocart);
        return new P02_LandingPage(driver);
    }

    public P02_LandingPage NavtoDetailsandadditem() {
        Utility.clickonElement(driver, Gotoitem2);
        Utility.clickonElement(driver, additem2);

        return new P02_LandingPage(driver);
    }

    public String getnumberofItems() {
        return Utility.gettext(driver, cartnumber);
    }

    public boolean comparingnumberofselecteditems() {
        return getnumberofItems().equals("2");
    }


    public P03_CartPage ClickonCarticon() {
        Utility.clickonElement(driver, Carticon);
        return new P03_CartPage(driver);
    }

}





