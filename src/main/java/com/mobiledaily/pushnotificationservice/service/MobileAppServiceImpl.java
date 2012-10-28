package com.mobiledaily.pushnotificationservice.service;

import com.mobiledaily.pushnotificationservice.domain.MobileApp;
import com.mobiledaily.pushnotificationservice.repository.NotificationRepository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: johnson
 * Date: 10/28/12
 * Time: 6:15 PM
 * To change this template use File | Settings | File Templates.
 */
@Service(value = "mobileAppService")
public class MobileAppServiceImpl implements MobileAppService {
    @Resource
    private NotificationRepository notificationRepository;

    @Override
    public void add(MobileApp app) {
        notificationRepository.addApp(app);
    }

    @Override
    public List<MobileApp> getApps() {
        return notificationRepository.getApps();
    }

    @Override
    public void remove(final String appKey) {
        notificationRepository.removeApp(appKey);
    }
}
