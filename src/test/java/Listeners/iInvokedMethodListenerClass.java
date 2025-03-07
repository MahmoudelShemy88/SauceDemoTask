package Listeners;

import Pages.P02_LandingPage;
import Utilities.LogsUtils;
import Utilities.Utility;
import org.testng.IInvokedMethod;
import org.testng.IInvokedMethodListener;
import org.testng.ITestResult;

import static DriverFactory.DriverFactory.getDriver;

public class iInvokedMethodListenerClass implements IInvokedMethodListener {

    public void beforeInvocation(IInvokedMethod method, ITestResult testResult) {

    }

    public void afterInvocation(IInvokedMethod method, ITestResult testResult) {
        if (testResult.getStatus() == ITestResult.FAILURE) {
            LogsUtils.info("TestCase" + testResult.getName() + "Failed");
            Utility.takeScreenShot(getDriver(), testResult.getName());
            Utility.takefullscreenshot(getDriver(), new P02_LandingPage(getDriver()).getNumberofSelectedProductsincart());
        }
    }
}
