package com.itachay.notification.service.impl;

import com.itachay.notification.dto.FirebaseMessageDTO;
import com.itachay.notification.dto.PushNotificationDTO;
import com.itachay.notification.service.NotificationService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Slf4j
@Service
@RequiredArgsConstructor
public class NotificationServiceImpl implements NotificationService {

    private final RestTemplate restTemplate;

    @Value("${firebase.endpoint}")
    private String firebaseEndpoint;

    @Value("${firebase.authorization.key}")
    private String firebaseAuthorizationKey;

    @Override
    public void push(PushNotificationDTO pushNotificationDTO) {
        try {
            for (String firebaseToken: pushNotificationDTO.getFirebaseTokens()) {
                HttpHeaders headers = new HttpHeaders();
                headers.set("Authorization", firebaseAuthorizationKey);
                FirebaseMessageDTO firebaseMessage = new FirebaseMessageDTO(pushNotificationDTO.getTitle(), pushNotificationDTO.getMessage(), true, firebaseToken);
                HttpEntity<FirebaseMessageDTO> requestEntity = new HttpEntity<>(firebaseMessage, headers);
                restTemplate.postForEntity(firebaseEndpoint, requestEntity, Object.class);
                log.info("Push notification sent to " + firebaseToken);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
