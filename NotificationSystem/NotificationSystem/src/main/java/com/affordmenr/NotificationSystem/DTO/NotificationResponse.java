package com.affordmenr.NotificationSystem.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
public class NotificationResponse {
    private String id;
    private String studentId;
    private String type;
    private String message;
    private boolean isRead;
    private int priority;
    private LocalDateTime createdAt;
}