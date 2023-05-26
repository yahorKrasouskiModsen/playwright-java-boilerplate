package tests.API.base;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import playwright.API.base.ApiExecutor;
import playwright.API.base.ApiUtils;

import static playwright.utils.PropertiesConstants.API_BASE_URL;

public class BaseApiTest {

    ApiExecutor apiExecutor = new ApiExecutor();

    @BeforeTest
    public void createContext() {
        apiExecutor.createAPIRequestContext(API_BASE_URL, ApiUtils.modsenHeaderCreator());
    }

    @AfterTest
    public void disposingAndClosePw() {
        apiExecutor.disposeAPIRequestContext();
        apiExecutor.closePlaywright();
    }
}
