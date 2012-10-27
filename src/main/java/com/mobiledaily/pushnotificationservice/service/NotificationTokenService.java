package com.mobiledaily.pushnotificationservice.service;

import com.mobiledaily.pushnotificationservice.domain.Location;
import com.mobiledaily.pushnotificationservice.domain.NotificationToken;

/**
 * Created with IntelliJ IDEA.
 * User: johnson
 * Date: 10/27/12
 * Time: 8:59 AM
 * To change this template use File | Settings | File Templates.
 */
public interface NotificationTokenService {
    public void register(final NotificationToken token);

    public void updateIdentity(String appKey, String serviceToken, String user);

    public void updateLocation(String appKey, String ServiceToken, Location location);
}
