package com.mobiledaily.pushnotificationservice.domain;

/**
 * Created with IntelliJ IDEA.
 * User: johnson
 * Date: 10/28/12
 * Time: 6:06 PM
 * To change this template use File | Settings | File Templates.
 */
public class MobileApp {
    public static final String APP_NAME = "appName";
    public static final String APP_DESC = "appDesc";
    public static final String PUSH_CERTIFICATE = "pushCertificate";
    private String appKey;
    private String appName;
    private String appDesc;
    private String pushCertificate;

    public String getAppName() {
        return appName;
    }

    public void setAppName(String appName) {
        this.appName = appName;
    }

    public String getAppDesc() {
        return appDesc;
    }

    public void setAppDesc(String appDesc) {
        this.appDesc = appDesc;
    }

    public String getPushCertificate() {
        return pushCertificate;
    }

    public void setPushCertificate(String pushCertificate) {
        this.pushCertificate = pushCertificate;
    }

    public String getAppKey() {
        return appKey;
    }

    public void setAppKey(String appKey) {
        this.appKey = appKey;
    }
}
