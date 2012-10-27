package com.mobiledaily.pushnotificationservice.domain;

import java.math.BigDecimal;

/**
 * Created with IntelliJ IDEA.
 * User: johnson
 * Date: 10/27/12
 * Time: 9:04 AM
 * To change this template use File | Settings | File Templates.
 */
public class Location {
    private final BigDecimal longitude;
    private final BigDecimal latitude;

    public Location(BigDecimal longitude, BigDecimal latitude) {
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public BigDecimal getLongitude() {
        return longitude;
    }

    public BigDecimal getLatitude() {
        return latitude;
    }

    public static Location valueOf(String longitude, String latitude) {
        BigDecimal lo = new BigDecimal(latitude);
        BigDecimal la = new BigDecimal(latitude);
        return new Location(lo, la);
    }
}
