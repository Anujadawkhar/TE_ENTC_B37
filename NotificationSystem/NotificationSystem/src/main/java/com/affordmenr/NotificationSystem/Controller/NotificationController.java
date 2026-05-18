package com.affordmenr.NotificationSystem.Controller;


import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import com.affordmenr.NotificationSystem.DTO.NotificationRequest;
import com.affordmenr.NotificationSystem.Entities.Notification;
import com.affordmenr.NotificationSystem.Service.NotificationService;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/notifications")
@RequiredArgsConstructor
public class NotificationController {

    private final NotificationService notificationService;

    @PostMapping
    public Notification create(
            @Valid @RequestBody NotificationRequest request
    ) {

        return notificationService.create(request);
    }

    @GetMapping("/{studentId}")
    public List<Notification> getAll(
            @PathVariable String studentId
    ) {

        return notificationService.getAll(studentId);
    }

    @GetMapping("/{studentId}/unread-count")
    public long unreadCount(
            @PathVariable String studentId
    ) {

        return notificationService.unreadCount(studentId);
    }

    @PatchMapping("/{id}/read")
    public Notification markRead(
            @PathVariable UUID id
    ) {

        return notificationService.markRead(id);
    }
}