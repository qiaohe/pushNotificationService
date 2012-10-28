package com.mobiledaily.pushnotificationservice.service;

import com.mobiledaily.pushnotificationservice.domain.NotificationToken;
import com.mobiledaily.pushnotificationservice.repository.NotificationRepository;
import javapns.Push;
import javapns.communication.exceptions.CommunicationException;
import javapns.communication.exceptions.KeystoreException;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: johnson
 * Date: 10/27/12
 * Time: 12:13 PM
 * To change this template use File | Settings | File Templates.
 */
@Service(value = "notificationService")
public class NotificationServiceImpl implements NotificationService {
    private static final Logger LOGGER = Logger.getLogger(NotificationService.class);
    @Resource
    private NotificationRepository notificationRepository;
    @Value("${push.keyStore}")
    private String keyStore;
    @Value("${push.keyStorePassword}")
    private String keyStorePassword;
    private String keyStorePath;

    @PostConstruct
    private void init() {
        try {
            keyStorePath = Thread.currentThread().getContextClassLoader().getResource(keyStore).getPath();
        } catch (NullPointerException ex) {
            LOGGER.error(ex.getMessage());
        }
    }

    public void send(final List<String> serviceTokens, final String message) {
        sendMessage(message, serviceTokens);
    }

    public void send(final String serviceToken, final String message) {
        List<String> tokens = new ArrayList<String>();
        tokens.add(serviceToken);
        sendMessage(message, tokens);
    }

    public void broadcast(final String appKey, final String message) {
        send(notificationRepository.getTokens(appKey), message);
    }

    public void broadcast(final String message) {
        for (NotificationToken token : notificationRepository.findAll()) {
            send(token.getServiceToken(), message);
        }
    }

    private void sendMessage(final String message, final List<String> serviceTokens) {
        try {
            Push.alert(message, keyStorePath, keyStorePassword, false, serviceTokens);
        } catch (CommunicationException e) {
            LOGGER.error(e.getMessage());
        } catch (KeystoreException e) {
            LOGGER.error(e.getMessage());
        } catch (NullPointerException e) {
            LOGGER.error(e.getMessage());
        }
    }
}
