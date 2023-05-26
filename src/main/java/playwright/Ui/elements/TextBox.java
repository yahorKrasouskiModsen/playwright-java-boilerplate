package playwright.Ui.elements;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;

/**
 * Class describing element input field
 */
public class TextBox extends Element {

    public TextBox(String elementName, String elementLocator) {
        super(elementName, elementLocator);
    }

    public Locator getTxtByRole(Page.GetByRoleOptions getByRoleOptions) {
        return getByRole(AriaRole.TEXTBOX, getByRoleOptions);
    }
}
