package playwright.utils;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.ScreenshotType;
import io.qameta.allure.Attachment;
import playwright.Ui.browser.BrowserActions;

public class Attachments {

    public static BrowserActions browserActions = new BrowserActions();

    @SuppressWarnings("all")
    @Attachment(value = "{0}", type = "image/png")
    public static byte[] captureScreenshotFullPage(String screenshotName) {
        return browserActions.getPage().screenshot(new Page.ScreenshotOptions()
                .setType(ScreenshotType.PNG).setFullPage(true));
    }
}
