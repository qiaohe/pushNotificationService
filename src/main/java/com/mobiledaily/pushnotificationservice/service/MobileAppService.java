package com.mobiledaily.pushnotificationservice.service;

import com.mobiledaily.pushnotificationservice.domain.MobileApp;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: johnson
 * Date: 10/28/12
 * Time: 6:12 PM
 * To change this template use File | Settings | File Templates.
 */
public interface MobileAppService {
    public void add(MobileApp app);

    public List<MobileApp> getApps();

    public void remove(String appKey);

}
