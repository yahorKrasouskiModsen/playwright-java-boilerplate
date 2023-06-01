package playwright.Ui.browser;

import com.microsoft.playwright.*;
import playwright.utils.PropertiesConstants;
import playwright.Ui.pages.base.BasePage;

import java.util.List;
import java.util.function.Consumer;

public class BrowserActions implements Browser {
    static Playwright playwright;
    Browser browser;
    Page page = BasePage.page;

    /**
     * Creates BrowserType instance for current browser session
     *
     * @return BrowserType
     */
    private BrowserType createBrowserType() {
        String browserName = PropertiesConstants.BROWSER_NAME;
        BrowserType browserType;
        playwright = getPlaywright();
        switch (browserName) {
            case "chromium" -> browserType = playwright.chromium();
            case "firefox" -> browserType = playwright.firefox();
            case "safari" -> browserType = playwright.webkit();
            default -> throw new IllegalArgumentException(String.format("Browser [%s] is not supported.", browserName));
        }
        return browserType;
    }

    /**
     * Creates Browser instance for current browser session
     *
     * @return Browser
     */
    public Browser createBrowser() {
        BrowserType browserType = createBrowserType();
        if (PropertiesConstants.HEAD_FULL_BROWSER_OPTION) {
            browser = browserType.launch(new BrowserType.LaunchOptions().setHeadless(false));
        } else {
            browser = browserType.launch(new BrowserType.LaunchOptions().setHeadless(true));
        }
        return browser;
    }

    /**
     * Provides Browser instance for current browser session
     *
     * @return Browser
     */
    public Browser getBrowser() {
        return browser = createBrowser();
    }

    /**
     * Closes the browser and all of its pages
     */
    @Override
    public void close() {
        if (getBrowser() != null) {
            getBrowser().close();
        }
    }

    /**
     * Indicates that the browser is connected
     */
    @Override
    public boolean isConnected() {
        return getBrowser().isConnected();
    }

    /**
     * Get the browser type that the browser belongs to
     *
     * @return BrowserType instance
     */
    @Override
    public BrowserType browserType() {
        return getBrowser().browserType();
    }

    /**
     * @return all open browser contexts
     */
    @Override
    public List<BrowserContext> contexts() {
        return getBrowser().contexts();
    }

    /**
     * Creates a new browser context
     * It won't share cookies/cache with other browser contexts
     *
     * @return BrowserContext instance
     */
    @Override
    public BrowserContext newContext(NewContextOptions newContextOptions) {
        return getBrowser().newContext(newContextOptions);
    }

    @Override
    public BrowserContext newContext() {
        return getBrowser().newContext();
    }

    /**
     * Creates a new page in a new browser context
     *
     * @return Page instance
     */
    @Override
    public Page newPage(NewPageOptions newPageOptions) {
        BrowserContext browserContext = getBrowser().newContext();
        return browserContext.newPage();
    }

    @Override
    public Page newPage() {
        try {
            page = (newContext().newPage());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return page;
    }

    public Page getPage() {
        return page;
    }

    /**
     * Starts tracing for trace file
     * (Chromium only)
     */
    @Override
    public void startTracing(Page page, StartTracingOptions startTracingOptions) {
        getBrowser().startTracing(page, startTracingOptions);
    }

    /**
     * Stops tracing for trace file
     * (Chromium only)
     */
    @Override
    public byte[] stopTracing() {
        return getBrowser().stopTracing();
    }

    /**
     * Returns the browser version
     */
    @Override
    public String version() {
        return getBrowser().version();
    }

    @Override
    public void onDisconnected(Consumer<Browser> consumer) {

    }

    @Override
    public void offDisconnected(Consumer<Browser> consumer) {

    }

    public Playwright getPlaywright() {
        if (playwright == null) {
            playwright = createPlaywright();
        }
        return playwright;
    }

    /**
     * Provides Playwright instance for current playwright session
     *
     * @return Playwright
     */
    public Playwright createPlaywright() {
        return playwright = Playwright.create();
    }

    /**
     * Closes Playwright instance for current browser session
     */
    public void closePlaywright() {
        if (playwright != null) {
            playwright.close();
        }
    }
}
