package com.itachay.notification.dto;

import lombok.Data;

import java.util.List;

@Data
public class PushNotificationDTO {
    private String title;
    private String message;
    private List<String> firebaseTokens;
}
