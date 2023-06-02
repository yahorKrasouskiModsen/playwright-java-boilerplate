package tests.Ui;

import org.testng.Assert;
import org.testng.annotations.Test;
import playwright.Ui.pages.ModsenContactPage;
import playwright.Ui.pages.ModsenHomePage;
import tests.Ui.base.BaseUiTest;

public class ModsenTest extends BaseUiTest {

    @Test
    public void checkHomePageTitle() {
        ModsenHomePage modsenHomePage = createInstance(ModsenHomePage.class);
        String title = modsenHomePage.getHomePageTitle();
        Assert.assertEquals(title, "Modsen123 | Modern Software Engineering",
                "Title is not equal to expected");
    }

    @Test
    public void clickGetStartedButton() {
        ModsenHomePage modsenHomePage = createInstance(ModsenHomePage.class);
        ModsenContactPage modsenContactPage = createInstance(ModsenContactPage.class);
        modsenHomePage.clickGetStarted();
        String title = modsenContactPage.getContactPageTitle();
        Assert.assertEquals(title, "Modsen | Contact Us",
                "Title is not equal to expected");
    }
}
