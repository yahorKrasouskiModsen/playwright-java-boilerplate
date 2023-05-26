package playwright.Ui.pages.base;

import com.microsoft.playwright.Page;

public class BasePage {

    public static Page page;

    public void setAndConfigurePage(Page page) {
        BasePage.page = page;
    }

    public String getPageTitle() {
        page.waitForLoadState();
        return page.title();
    }
}
