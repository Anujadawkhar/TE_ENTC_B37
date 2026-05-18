package com.affordmenr.NotificationSystem.Service;

import com.affordmenr.NotificationSystem.DTO.NotificationRequest;
import com.affordmenr.NotificationSystem.Entities.Notification;
import com.affordmenr.NotificationSystem.Repositories.NotificationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class NotificationService {

    private final NotificationRepository notificationRepository;

    public Notification create(NotificationRequest request) {

        Notification notification = new Notification();

        notification.setStudentId(request.getStudentId());
        notification.setType(request.getType());
        notification.setMessage(request.getMessage());
        notification.setRead(false);
        notification.setCreatedAt(LocalDateTime.now());

        notification.setPriority(getPriority(request.getType()));

        return notificationRepository.save(notification);
    }

    public List<Notification> getAll(String studentId) {

        return notificationRepository
                .findByStudentIdOrderByCreatedAtDesc(studentId);
    }

    public long unreadCount(String studentId) {

        return notificationRepository
                .countByStudentIdAndReadFalse(studentId);
    }

    public Notification markRead(UUID id) {

        Notification notification =
                notificationRepository.findById(id)
                        .orElseThrow(() ->
                                new RuntimeException("Notification not found")
                        );

        notification.setRead(true);

        return notificationRepository.save(notification);
    }

    private int getPriority(String type) {

        if (type.equalsIgnoreCase("Placement")) {
            return 3;
        }

        if (type.equalsIgnoreCase("Result")) {
            return 2;
        }

        return 1;
    }
}