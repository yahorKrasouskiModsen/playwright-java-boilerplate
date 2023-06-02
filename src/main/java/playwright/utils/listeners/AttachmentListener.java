package playwright.utils.listeners;

import io.qameta.allure.listener.TestLifecycleListener;
import io.qameta.allure.model.Status;
import io.qameta.allure.model.TestResult;
import playwright.utils.Attachments;

public class AttachmentListener implements TestLifecycleListener {


    @Override
    public void beforeTestStop(TestResult result) {
        if (result.getStatus() == Status.FAILED || result.getStatus() == Status.BROKEN) {
            takeScreenshot(result);
        }
    }

    private void takeScreenshot(TestResult result) {
        try {
            Attachments.captureScreenshot(String.format("failed_%s_test", result.getName()));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
