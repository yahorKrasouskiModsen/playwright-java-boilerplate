package tests.API;

import org.testng.Assert;
import org.testng.annotations.Test;
import playwright.API.ModsenApi;
import tests.API.base.BaseApiTest;

public class ExampleApiTest extends BaseApiTest {

    @Test
    public void modsenAuth() {
        ModsenApi modsenApi = new ModsenApi();
        Assert.assertTrue(modsenApi.auth().ok());
    }
}
