package com.itachay.notification.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class FirebaseMessageDTO {
    public static class Notification{
        @JsonProperty("title")
        public String title;
        @JsonProperty("body")
        public String body;
        @JsonProperty("other_key")
        public boolean other_key;

        public Notification() {
        }

        public Notification(String title, String body, boolean other_key) {
            this.title = title;
            this.body = body;
            this.other_key = other_key;
        }

    }

    @JsonProperty("notification")
    public Notification notification;
    @JsonProperty("to")
    public String to;

    public FirebaseMessageDTO() {
    }

    public FirebaseMessageDTO(String title, String body, boolean other_key, String to) {
        this.notification = new Notification(title, body, other_key);
        this.to = to;
    }

    public Notification getNotification() {
        return notification;
    }

    public void setNotification(Notification notification) {
        this.notification = notification;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }
}
