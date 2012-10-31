package com.mobiledaily.pushnotificationservice.repository;

/**
 * Created with IntelliJ IDEA.
 * User: johnson
 * Date: 10/27/12
 * Time: 1:05 PM
 * To change this template use File | Settings | File Templates.
 */
public final class KeyUtil {
    private static final String MATCH_TOKEN_KEY_PATTERN = "appKey:%s:serviceToken:*";
    private static final String TOKEN_KEY_PATTERN = "appKey:%s:serviceToken:%s";
    private static final String APP_KEY_PATTERN = "app:%s";

    public static final String MATCH_APPKEY = "appKey:*";
    public static final String MATCH_APP = "app:*";

    public static String matchTokenKey(final String appKey) {
        return String.format(MATCH_TOKEN_KEY_PATTERN, appKey);
    }

    public static String tokenKey(String appKey, String serviceToken) {
        return String.format(TOKEN_KEY_PATTERN, appKey, serviceToken);
    }

    public static String mobileApp(final String appKey) {
        return String.format(APP_KEY_PATTERN, appKey);
    }

    public static String accountKey(final String userName) {
        return String.format("user:" + userName, userName);
    }
}
