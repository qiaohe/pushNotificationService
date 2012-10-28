package com.mobiledaily.pushnotificationservice.web;

import com.mobiledaily.pushnotificationservice.domain.NotificationToken;
import com.mobiledaily.pushnotificationservice.service.NotificationService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: johnson
 * Date: 10/28/12
 * Time: 1:05 PM
 * To change this template use File | Settings | File Templates.
 */
@Controller
public class NotificationSenderController {
    @Resource
    private NotificationService notificationService;

    @RequestMapping(value = "/push", method = RequestMethod.POST)
    public String pushNotification(HttpServletRequest request) {
        String serviceToken = request.getParameter("serviceToken");
        String message = request.getParameter("message");
        notificationService.send(serviceToken, message);
        return "push";
    }
}
