package playwright.API;

import com.microsoft.playwright.APIResponse;
import playwright.API.base.ApiExecutor;

public class ModsenApi extends ApiExecutor {

    public APIResponse auth() {
        return ApiExecutor.request.get("/api/auth/session");
    }
}
