package com.mobiledaily.pushnotificationservice.web;

import com.mobiledaily.pushnotificationservice.domain.NotificationToken;
import com.mobiledaily.pushnotificationservice.service.NotificationTokenService;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;

/**
 * Created with IntelliJ IDEA.
 * User: johnson
 * Date: 10/27/12
 * Time: 8:16 AM
 * This class is responsible for registering the notification service based on different
 * mobile platforms like Android and iOS.
 */
@Controller
public class NotificationRegisteringController {
    @Resource
    private NotificationTokenService notificationTokenService;

    public void register(NotificationToken token) {
        notificationTokenService.register(token);
    }
}
