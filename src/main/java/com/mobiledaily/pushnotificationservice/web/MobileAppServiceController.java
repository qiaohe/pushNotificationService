package com.mobiledaily.pushnotificationservice.web;

import com.mobiledaily.pushnotificationservice.domain.MobileApp;
import com.mobiledaily.pushnotificationservice.service.MobileAppService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: johnson
 * Date: 10/28/12
 * Time: 6:08 PM
 * To change this template use File | Settings | File Templates.
 */
@Controller
public class MobileAppServiceController {
    @Resource
    private MobileAppService mobileAppService;

    @RequestMapping(value = "/apps/add", method = RequestMethod.GET)
    public void addApp(@RequestBody MobileApp app) {
        mobileAppService.add(app);
    }

    @RequestMapping(value = "/apps", method = RequestMethod.GET)
    public
    @ResponseBody
    List<MobileApp> getApps() {
        return mobileAppService.getApps();
    }

    @RequestMapping(value = "/apps/remove/{appKey}", method = RequestMethod.GET)
    public
    @ResponseBody
    void removeApp(@PathVariable String appKey) {
        mobileAppService.remove(appKey);
    }

}
