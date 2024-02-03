package com.itachay.notification.controller;

import com.itachay.notification.dto.ApiResponseDTO;
import com.itachay.notification.dto.PushNotificationDTO;
import com.itachay.notification.service.NotificationService;
import com.itachay.notification.utils.Constants;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/api/notifications")
@RequiredArgsConstructor
public class NotificationController {

    private final NotificationService notificationService;

    @PostMapping("push")
    public ResponseEntity send(@RequestBody PushNotificationDTO pushNotificationDTO) {
        log.info("Entering PushNotificationController.send");
        notificationService.push(pushNotificationDTO);
        return new ResponseEntity<ApiResponseDTO>(
                new ApiResponseDTO(Constants.STATUS_CODE_SUCCESS, Constants.STATUS_MESSAGE_SUCCESS, "Push Notification sent"),
                HttpStatus.OK);
    }
}