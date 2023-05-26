package playwright.API.base;

import com.microsoft.playwright.*;
import com.microsoft.playwright.options.RequestOptions;

import java.util.Map;

public class ApiExecutor implements APIRequestContext {

    public static Playwright playwright;
    public static APIRequestContext request;

    public void createAPIRequestContext(String baseUrl, Map<String, String> headers) {
        request = getPlaywright().request().newContext(new APIRequest.NewContextOptions()
                .setBaseURL(baseUrl).setExtraHTTPHeaders(headers));
    }

    /**
     * Discards all stored responses for current session
     */
    @Override
    public void dispose() {
        request.dispose();
    }

    public void disposeAPIRequestContext() {
        if (request != null) {
            dispose();
            request = null;
        }
    }

    /**
     * Sends HTTP(S) request and returns its response.
     * JSON objects can be passed directly to the request
     *
     * @return APIResponse
     */
    @Override
    public APIResponse fetch(String url) {
        return request.fetch(url);
    }

    @Override
    public APIResponse fetch(String url, RequestOptions requestOptions) {
        return request.fetch(url, requestOptions);
    }

    @Override
    public APIResponse fetch(Request req, RequestOptions requestOptions) {
        return request.fetch(req, requestOptions);
    }

    /**
     * Sends HTTP(S) GET request and returns its response
     *
     * @return APIResponse
     */
    @Override
    public APIResponse get(String url) {
        return request.get(url);
    }

    @Override
    public APIResponse get(String url, RequestOptions requestOptions) {
        return request.get(url, requestOptions);
    }

    /**
     * Sends HTTP(S) HEAD request and returns its response
     *
     * @return APIResponse
     */
    @Override
    public APIResponse head(String url) {
        return request.head(url);
    }

    @Override
    public APIResponse head(String url, RequestOptions requestOptions) {
        return request.head(url, requestOptions);
    }

    /**
     * Sends HTTP(S) PATCH request and returns its response
     *
     * @return APIResponse
     */
    @Override
    public APIResponse patch(String url) {
        return request.patch(url);
    }

    @Override
    public APIResponse patch(String url, RequestOptions requestOptions) {
        return request.patch(url, requestOptions);
    }

    /**
     * Sends HTTP(S) POST request and returns its response
     * JSON objects can be passed directly to the request
     *
     * @return APIResponse
     */
    @Override
    public APIResponse post(String url) {
        return request.post(url);
    }

    @Override
    public APIResponse post(String url, RequestOptions requestOptions) {
        return request.post(url, requestOptions);
    }

    /**
     * Sends HTTP(S) PUT request and returns its response
     *
     * @return APIResponse
     */
    @Override
    public APIResponse put(String url) {
        return request.put(url);
    }

    @Override
    public APIResponse put(String url, RequestOptions requestOptions) {
        return request.put(url, requestOptions);
    }

    /**
     * Sends HTTP(S) DELETE request and returns its response
     *
     * @return APIResponse
     */
    @Override
    public APIResponse delete(String url) {
        return request.delete(url);
    }

    @Override
    public APIResponse delete(String url, RequestOptions requestOptions) {
        return request.delete(url, requestOptions);
    }

    /**
     * Returns storage state for this request context.
     * Contains current cookies and local storage snapshot
     * if it was passed to the constructor
     */
    @Override
    public String storageState() {
        return request.storageState();
    }

    @Override
    public String storageState(APIRequestContext.StorageStateOptions storageStateOptions) {
        return request.storageState(storageStateOptions);
    }

    /**
     * Provides Playwright instance for current session
     *
     * @return Playwright
     */
    public Playwright getPlaywright() {
        if (playwright == null) {
            playwright = Playwright.create();
        }
        return playwright;
    }

    /**
     * Closes Playwright instance for current browser session
     */
    public void closePlaywright() {
        if (playwright != null) {
            playwright.close();
        }
    }
}
