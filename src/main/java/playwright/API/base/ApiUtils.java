package playwright.API.base;

import java.util.HashMap;
import java.util.Map;

public class ApiUtils {

    public static Map<String, String> modsenHeaderCreator() {
        Map<String, String> headers = new HashMap<>();
        headers.put("Accept", "*/*");
        headers.put("Accept-Encoding", "gzip, deflate, br");
        headers.put("Accept-Language", "ru-RU,ru;q=0.9,en-US;q=0.8,en;q=0.7");
        return headers;
    }
}
