package Utilities;

import com.assertthat.selenium_shutterbug.core.Capture;
import com.assertthat.selenium_shutterbug.core.Shutterbug;
import io.qameta.allure.Allure;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

public class Utility {
    private static final String SCREENSHOTS_PATH = "test-output/Screenshots";

    public static void clickonElement(WebDriver driver, By loctor) {
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.elementToBeClickable(loctor));
        driver.findElement(loctor).click();
    }

    public static void senddata(WebDriver driver, By loctor, String data) {
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.visibilityOfElementLocated(loctor));
        driver.findElement(loctor).sendKeys(data);
    }

    public static String gettext(WebDriver driver, By loctor) {
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.visibilityOfElementLocated(loctor));
        return driver.findElement(loctor).getText();
    }

    public static WebDriverWait generalwait(WebDriver driver) {
        return new WebDriverWait(driver, Duration.ofSeconds(5));
    }

    public static void selectingFromdropdown(WebDriver driver, By loctor, String option) {
        new Select(findWebelement(driver, loctor)).selectByVisibleText(option);
    }

    public static void scrolling(WebDriver driver, By loctor) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", findWebelement(driver, loctor));
    }

    public static WebElement findWebelement(WebDriver driver, By loctor) {
        return driver.findElement(loctor);
    }


    public static String getTimestamp() {
        return new SimpleDateFormat("yyyy=MM-dd-h-m-ssa").format(new Date());
    }

    public static void takeScreenShot(WebDriver driver, String screenshotName) {
        try {
            //captureScreenshot using TakesScreenshot
            File screenshotSrc = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

            //SaveScreenshot to file if needed
            File screenshotFile = new File("test-output/Screenshots" + screenshotName + "-" + getTimestamp() + ".png");
            FileUtils.copyFile(screenshotSrc, screenshotFile);
            //Attach the Screenshot to Allure
            Allure.addAttachment(screenshotName, Files.newInputStream(Path.of(screenshotFile.getPath())));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void takefullscreenshot(WebDriver driver, By loctor) {
        Shutterbug.shootPage(driver, Capture.FULL_SCROLL).highlight(findWebelement(driver, loctor)).save("test-output/Screenshots");

    }
}
