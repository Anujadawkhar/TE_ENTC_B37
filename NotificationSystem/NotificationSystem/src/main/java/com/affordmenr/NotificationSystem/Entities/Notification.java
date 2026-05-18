package com.affordmenr.NotificationSystem.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "notifications")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Notification {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    private String studentId;

    private String type; // Placement / Result / Event

    @Column(columnDefinition = "TEXT")
    private String message;

    private boolean isRead = false;

    private int priority;

    private LocalDateTime createdAt;
}