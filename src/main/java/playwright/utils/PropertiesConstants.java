package playwright.utils;

import java.util.ResourceBundle;

public class PropertiesConstants {

    private static final String PROPERTIES_FILE_NAME = "browser";
    public static final String BROWSER_NAME = ResourceBundle.getBundle(PROPERTIES_FILE_NAME).getString("browserName");
    public static final boolean HEAD_FULL_BROWSER_OPTION = Boolean.parseBoolean(ResourceBundle.getBundle(PROPERTIES_FILE_NAME).getString("headFullBrowser"));
    public static final boolean FULL_PAGE_SCREENSHOT_OPTION = Boolean.parseBoolean(ResourceBundle.getBundle(PROPERTIES_FILE_NAME).getString("fullPageScreenshot"));
    public static final String API_BASE_URL = ResourceBundle.getBundle(PROPERTIES_FILE_NAME).getString("apiBaseUrl");
    public static final String UI_BASE_URL = ResourceBundle.getBundle(PROPERTIES_FILE_NAME).getString("uiBaseUrl");
}
