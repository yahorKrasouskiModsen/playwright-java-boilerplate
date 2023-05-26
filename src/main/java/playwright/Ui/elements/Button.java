package playwright.Ui.elements;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;

/**
 * Class describing element button
 */
public class Button extends Element {
    public Button(String elementName, String elementLocator) {
        super(elementName, elementLocator);
    }

    public Locator getBtnByRole(Page.GetByRoleOptions getByRoleOptions) {
        return getByRole(AriaRole.BUTTON, getByRoleOptions);
    }
}
