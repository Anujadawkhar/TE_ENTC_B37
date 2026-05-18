package com.affordmenr.NotificationSystem.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.affordmenr.NotificationSystem.Entities.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, String> {
    Optional<User> findByEmail(String email);
}
