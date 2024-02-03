package com.itachay.notification.service;

import com.itachay.notification.dto.PushNotificationDTO;

public interface NotificationService {
    void push(PushNotificationDTO pushNotificationDTO);
}
