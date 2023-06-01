package playwright.utils.listeners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import playwright.utils.Attachments;

public class AttachmentListener implements ITestListener {

    @Override
    public void onTestFailure(ITestResult iTestResult) {
        getFailedTestScreenshotFullPage(iTestResult);
    }

    @Override
    public void onTestStart(ITestResult iTestResult) {

    }

    @Override
    public void onTestSuccess(ITestResult iTestResult) {

    }

    @Override
    public void onTestSkipped(ITestResult iTestResult) {

    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {

    }

    @Override
    public void onStart(ITestContext iTestContext) {

    }

    @Override
    public void onFinish(ITestContext iTestContext) {

    }

    private void getFailedTestScreenshotFullPage(ITestResult iTestResult) {
        try {
            Attachments.captureScreenshotFullPage(String.format("failed_%s_test", iTestResult.getName()));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
