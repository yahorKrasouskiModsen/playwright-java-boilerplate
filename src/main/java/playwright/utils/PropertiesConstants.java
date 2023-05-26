package playwright.utils;

import java.util.ResourceBundle;

public class PropertiesConstants {

    private static final String PROPERTIES_FILE_NAME = "browser";
    public static final String BROWSER_NAME = ResourceBundle.getBundle(PROPERTIES_FILE_NAME).getString("browserName");
    public static final String HEADFUL_OPTION = ResourceBundle.getBundle(PROPERTIES_FILE_NAME).getString("headFulOption");
    public static final String API_BASE_URL = ResourceBundle.getBundle(PROPERTIES_FILE_NAME).getString("apiBaseUrl");
    public static final String UI_BASE_URL = ResourceBundle.getBundle(PROPERTIES_FILE_NAME).getString("uiBaseUrl");
}
