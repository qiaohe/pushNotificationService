package com.mobiledaily.pushnotificationservice.service;

import com.mobiledaily.pushnotificationservice.domain.Location;
import com.mobiledaily.pushnotificationservice.domain.NotificationToken;
import com.mobiledaily.pushnotificationservice.repository.NotificationRepository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created with IntelliJ IDEA.
 * User: johnson
 * Date: 10/27/12
 * Time: 9:07 AM
 * To change this template use File | Settings | File Templates.
 */
@Service(value = "notificationTokenService")
public class NotificationTokenServiceImpl implements NotificationTokenService {
    @Resource
    private NotificationRepository notificationRepository;

    @Override
    public void register(NotificationToken token) {
    }

    @Override
    public void updateIdentity(String appKey, String serviceToken, String user) {
    }

    @Override
    public void updateLocation(String appKey, String ServiceToken, Location location) {
    }
}
