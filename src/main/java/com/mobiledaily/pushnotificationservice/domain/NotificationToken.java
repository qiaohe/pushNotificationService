package com.mobiledaily.pushnotificationservice.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * Created with IntelliJ IDEA.
 * User: johnson
 * Date: 10/27/12
 * Time: 8:42 AM
 * To change this template use File | Settings | File Templates.
 */
public class NotificationToken {
    public static final String PATTERN = "appKey:%s:serviceToken:%s";
    public static final String USERNAME = "userName";
    public static final String LONGITUDE = "longitude";
    public static final String LATITUDE = "longitude";
    private String appKey;
    private String serviceToken;
    private String userName;
    private String longitude;
    private String latitude;

    public NotificationToken() {
    }

    public NotificationToken(String appKey, String serviceToken) {
        this.appKey = appKey;
        this.serviceToken = serviceToken;
    }

    public String getAppKey() {
        return appKey;
    }

    public void setAppKey(String appKey) {
        this.appKey = appKey;
    }

    public String getServiceToken() {
        return serviceToken;
    }

    public void setServiceToken(String serviceToken) {
        this.serviceToken = serviceToken;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    @JsonIgnore
    public Location getLocation() {
        return Location.valueOf(longitude, latitude);
    }

    @Override
    public String toString() {
        return String.format(PATTERN, getAppKey(), getServiceToken());
    }
}
