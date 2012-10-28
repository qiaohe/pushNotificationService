package com.mobiledaily.pushnotificationservice.repository;

import com.mobiledaily.pushnotificationservice.domain.MobileApp;
import com.mobiledaily.pushnotificationservice.domain.NotificationToken;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

import static com.mobiledaily.pushnotificationservice.repository.KeyUtil.MATCH_APPKEY;

/**
 * Created with IntelliJ IDEA.
 * User: johnson
 * Date: 10/27/12
 * Time: 11:56 AM
 * To change this template use File | Settings | File Templates.
 */
@Repository(value = "notificationRepository")
public class NotificationRepositoryImpl implements NotificationRepository {
    @Resource(name = "template")
    private StringRedisTemplate template;
    private HashOperations<String, String, String> hashOperations;

    @PostConstruct
    private void init() {
        hashOperations = template.opsForHash();
    }

    @Override
    public void add(NotificationToken token) {
        final String key = KeyUtil.tokenKey(token.getAppKey(), token.getServiceToken());
        hashOperations.put(key, NotificationToken.USERNAME, token.getUserName());
        hashOperations.put(key, NotificationToken.LONGITUDE, token.getLongitude());
        hashOperations.put(key, NotificationToken.LATITUDE, token.getLatitude());
        template.persist(key);
    }

    @Override
    public void remove(NotificationToken token) {
        final String key = KeyUtil.tokenKey(token.getAppKey(), token.getServiceToken());
        hashOperations.delete(key, NotificationToken.USERNAME);
        hashOperations.delete(key, NotificationToken.LONGITUDE);
        hashOperations.delete(key, NotificationToken.LATITUDE);
        template.delete(key);
    }

    public List<String> getAppKeys() {
        List<String> result = new ArrayList<String>();
        for (String k : template.keys(MATCH_APPKEY)) {
            result.add(Key.valueOf(k).getServiceToken());
        }
        return result;
    }

    public List<String> getTokens(final String appKey) {
        List<String> result = new ArrayList<String>();
        for (String k : template.keys(KeyUtil.matchTokenKey(appKey))) {
            result.add(Key.valueOf(k).getServiceToken());
        }
        return result;
    }

    public NotificationToken findBy(final String appKey, final String serviceToken) {
        NotificationToken result = new NotificationToken();
        result.setAppKey(appKey);
        result.setServiceToken(serviceToken);
        final String key = KeyUtil.tokenKey(appKey, serviceToken);
        result.setUserName(get(key, NotificationToken.USERNAME));
        result.setLatitude(get(key, NotificationToken.LATITUDE));
        result.setLongitude(get(key, NotificationToken.LONGITUDE));
        return result;
    }

    public List<NotificationToken> findBy(final String appKey) {
        List<NotificationToken> result = new ArrayList<NotificationToken>();
        for (String token : getTokens(appKey)) {
            result.add(findBy(appKey, token));
        }
        return result;
    }

    @Override
    public List<NotificationToken> findAll() {
        List<NotificationToken> result = new ArrayList<NotificationToken>();
        for (String k : template.keys(MATCH_APPKEY)) {
            Key key = Key.valueOf(k);
            result.add(findBy(key.getAppKey(), key.getServiceToken()));
        }
        return result;
    }

    @Override
    public void addApp(MobileApp app) {
        final String key = KeyUtil.mobileApp(app.getAppKey());
        hashOperations.put(key, MobileApp.APP_NAME, app.getAppName());
        hashOperations.put(key, MobileApp.APP_DESC, app.getAppDesc());
        hashOperations.put(key, MobileApp.PUSH_CERTIFICATE, app.getPushCertificate());
        template.persist(key);
    }

    @Override
    public void removeApp(String appKey) {
        final String key = KeyUtil.mobileApp(appKey);
        hashOperations.delete(key, MobileApp.APP_NAME);
        hashOperations.delete(key, MobileApp.APP_DESC);
        hashOperations.delete(key, MobileApp.PUSH_CERTIFICATE);
        template.delete(key);
    }

    @Override
    public MobileApp getApp(String appKey) {
        MobileApp result = new MobileApp();
        result.setAppKey(appKey);
        final String key = KeyUtil.mobileApp(appKey);
        result.setAppName(hashOperations.get(key, MobileApp.APP_NAME));
        result.setAppDesc(hashOperations.get(key, MobileApp.APP_DESC));
        result.setPushCertificate(hashOperations.get(key, MobileApp.PUSH_CERTIFICATE));
        return result;
    }

    @Override
    public List<MobileApp> getApps() {
        List<MobileApp> result = new ArrayList<MobileApp>();
        for (String k : template.keys(KeyUtil.MATCH_APP)) {
            final String appKey = k.substring(4);
            result.add(getApp(appKey));
        }
        return result;
    }

    private String get(final String key, final String hashKey) {
        return hashOperations.get(key, hashKey);
    }

    public static final class Key {
        private final String appKey;
        private final String serviceToken;

        public Key(String appKey, String serviceToken) {
            this.appKey = appKey;
            this.serviceToken = serviceToken;
        }

        public String getAppKey() {
            return appKey;
        }

        public String getServiceToken() {
            return serviceToken;
        }

        public static Key valueOf(final String k) {
            String[] parts = k.split(":");
            return new Key(parts[1], parts[3]);
        }
    }

    public static void main(String[] args) {
        ApplicationContext ctx = new FileSystemXmlApplicationContext("src/main/webapp/WEB-INF/applicationContext.xml");
        NotificationRepository repository = ctx.getBean("notificationRepository", NotificationRepository.class);
        NotificationToken token = new NotificationToken();
        token.setAppKey("00000");
        token.setLatitude("12.0000");
        token.setLongitude("35.000001");
        token.setUserName("Johnson");
        token.setServiceToken("12ea0103f");
        repository.add(token);
    }
}
