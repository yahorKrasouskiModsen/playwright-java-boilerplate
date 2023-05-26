package tests.Ui.base;

import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.Page;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import playwright.Ui.browser.BrowserActions;
import playwright.Ui.pages.ModsenHomePage;
import playwright.Ui.pages.base.BasePage;
import playwright.Ui.pages.base.BasePageFactory;

import static playwright.utils.PropertiesConstants.UI_BASE_URL;

public class BaseUiTest {

    BrowserActions browserActions = new BrowserActions();
    protected BrowserContext browserContext;
    protected Page page;

    @BeforeTest
    public void initializePlaywright() {
        browserActions.createPlaywright();
    }

    @BeforeMethod
    public void initializeBrowserContextAndPage() {
        browserContext = browserActions.newContext();
        page = browserContext.newPage();
        ModsenHomePage modsenHomePage = createInstance(ModsenHomePage.class);
        modsenHomePage.open(UI_BASE_URL);
    }

    @AfterMethod
    public void closeBrowserContext() {
        browserContext.close();
    }

    @AfterTest
    public void closeBrowserAndPlaywright() {
        browserActions.close();
        browserActions.closePlaywright();
    }

    protected <T extends BasePage> T createInstance(Class<T> basePage) {
        return BasePageFactory.createInstance(page, basePage);
    }
}
