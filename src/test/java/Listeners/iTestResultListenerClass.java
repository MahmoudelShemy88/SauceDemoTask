package Listeners;

import Utilities.LogsUtils;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class iTestResultListenerClass implements ITestListener {


    public void onTestStart(ITestResult result) {
        LogsUtils.info("TestCase"+ result.getName()+"Started");

    }

    public void onTestSuccess(ITestResult result) {
        LogsUtils.info("TestCase"+ result.getName()+"passed");
    }

    public void onTestSkipped(ITestResult result) {
        LogsUtils.info("TestCase"+ result.getName()+"skipped");
    }

}
