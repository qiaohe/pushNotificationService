package com.mobiledaily.pushnotificationservice.repository;

import com.mobiledaily.pushnotificationservice.domain.MobileApp;
import com.mobiledaily.pushnotificationservice.domain.NotificationToken;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: johnson
 * Date: 10/27/12
 * Time: 10:17 AM
 * To change this template use File | Settings | File Templates.
 */
public interface NotificationRepository {
    public void add(NotificationToken token);

    public void remove(NotificationToken token);

    public List<String> getAppKeys();

    public List<String> getTokens(final String appKey);

    public NotificationToken findBy(final String appKey, final String serviceToken);

    public List<NotificationToken> findBy(final String appKey);

    public List<NotificationToken> findAll();

    public void addApp(MobileApp app);

    public void removeApp(String appKey);

    public MobileApp getApp(String appKey);

    public List<MobileApp> getApps();
}
