package playwright.Ui.pages.base;

import com.microsoft.playwright.Page;

public class BasePageFactory {

    public static <T extends BasePage> T createInstance(Page page, Class<T> basePage) {
        try {
            BasePage instance = basePage.getDeclaredConstructor().newInstance();
            instance.setAndConfigurePage(page);

            return basePage.cast(instance);
        } catch (Exception e) {
            e.printStackTrace();
        }

        throw new NullPointerException("Page class instantiation failed.");
    }
}
