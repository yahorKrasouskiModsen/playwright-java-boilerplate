package playwright.Ui.elements;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import playwright.Ui.browser.BrowserActions;

import java.util.regex.Pattern;

/**
 * Abstract class, describing wrapper of WebElement.
 */
public abstract class Element {

    private final String elementName;

    private final String elementLocator;
    BrowserActions browserActions = new BrowserActions();

    protected Element(String elementName, String elementLocator) {
        this.elementName = elementName;
        this.elementLocator = elementLocator;
    }

    /**
     * Locate the element by its role of
     * element type @param ariaRole and
     * name @param getByRoleOptions (optional)
     */
    public Locator getByRole(AriaRole ariaRole) {
        return browserActions.getPage().getByRole(ariaRole);
    }

    public Locator getByRole(AriaRole ariaRole, Page.GetByRoleOptions getByRoleOptions) {
        return browserActions.getPage().getByRole(ariaRole, getByRoleOptions);
    }

    /**
     * Locate the element by its associated label
     *
     * @param labelName Use this locator when locating form fields
     */
    public Locator getByLabel(String labelName) {
        return browserActions.getPage().getByLabel(labelName);
    }


    public Locator getByLabel(String labelName, Page.GetByLabelOptions getByLabelOptions) {
        return browserActions.getPage().getByLabel(labelName, getByLabelOptions);
    }

    /**
     * Locate the element by the text it contains
     *
     * @param text You can match by a substring, exact string,
     *             or a regular expression
     */
    public Locator getByText(String text) {
        return browserActions.getPage().getByText(text);
    }

    public Locator getByText(Pattern pattern) {
        return browserActions.getPage().getByText(pattern);
    }

    public Locator getByText(String text, Page.GetByTextOptions getByTextOptions) {
        return browserActions.getPage().getByText(text, getByTextOptions);
    }

    public Locator getByText(Pattern pattern, Page.GetByTextOptions getByTextOptions) {
        return browserActions.getPage().getByText(pattern, getByTextOptions);
    }

    /**
     * Locate the element by its test id
     *
     * @param testId
     */
    public Locator getByTestId(String testId) {
        return browserActions.getPage().getByTestId(testId);
    }

    /**
     * Locate the element by its
     * CSS or XPath locator
     *
     * @param selector
     */
    public Locator locator(String selector) {
        return browserActions.getPage().locator(selector);
    }

    /**
     * Locate the element by its XPath locator
     *
     * @param xpath
     */
    public Locator locateByXPath(String xpath) {
        return locator("xpath=" + xpath);
    }

    /**
     * Locate the element by its CSS locator
     *
     * @param css
     */
    public Locator locateByCSS(String css) {
        return locator("css=" + css);
    }

    public String getElementName() {
        return elementName;
    }

    public String getElementLocator() {
        return elementLocator;
    }
}
