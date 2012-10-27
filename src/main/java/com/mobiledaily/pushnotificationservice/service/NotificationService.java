package com.mobiledaily.pushnotificationservice.service;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: johnson
 * Date: 10/27/12
 * Time: 9:08 AM
 * To change this template use File | Settings | File Templates.
 */
public interface NotificationService {
    public void send(final String appKey, final List<String> serviceTokens);

    public void send(final String appKey, final String serviceToken);

    public void broadcast(final String appKey);

    public void broadcast();

}
