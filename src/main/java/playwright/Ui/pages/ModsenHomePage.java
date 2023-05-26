package playwright.Ui.pages;

import playwright.Ui.elements.Button;
import playwright.Ui.pages.base.BasePage;

public class ModsenHomePage extends BasePage {

    Button getStartedBtn = new Button("Get Started", "//*[@id='get stared']");

    public void clickGetStarted() {
        getStartedBtn.locateByXPath(getStartedBtn.getElementLocator()).click();
    }

    public String getHomePageTitle() {
        return getPageTitle();
    }

    public void open(String url) {
        page.navigate(url);
    }
}
