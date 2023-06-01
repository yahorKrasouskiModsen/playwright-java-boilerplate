package playwright.utils.listeners;

import org.testng.ITestListener;
import org.testng.ITestResult;
import playwright.utils.Attachments;

public class AttachmentListener implements ITestListener {

    @Override
    public void onTestFailure(ITestResult iTestResult) {
        getFailedTestScreenshotFullPage(iTestResult);
    }

    private void getFailedTestScreenshotFullPage(ITestResult iTestResult) {
        try {
            Attachments.captureScreenshotFullPage(String.format("failed_%s_test", iTestResult.getName()));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
