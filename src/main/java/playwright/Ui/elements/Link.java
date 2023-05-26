package playwright.Ui.elements;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;

/**
 * Class describing element link
 */
public class Link extends Element {

    public Link(String elementName, String elementLocator) {
        super(elementName, elementLocator);
    }

    public Locator getLinkByRole(Page.GetByRoleOptions getByRoleOptions) {
        return getByRole(AriaRole.LINK, getByRoleOptions);
    }
}
