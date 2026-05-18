package com.affordmenr.NotificationSystem.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.affordmenr.NotificationSystem.Entities.Notification;

import java.util.List;

import java.util.UUID;

public interface NotificationRepository extends JpaRepository<Notification, UUID> {

    List<Notification> findByStudentIdOrderByCreatedAtDesc(String studentId);

    long countByStudentIdAndReadFalse(String studentId);
}