package com.affordmenr.NotificationSystem.Data;


import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.affordmenr.NotificationSystem.Entities.User;
import com.affordmenr.NotificationSystem.Repositories.UserRepository;

@Component
@RequiredArgsConstructor
public class DataSeeder implements CommandLineRunner {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public void run(String... args) {

        if (userRepository.findByEmail(
                "student@college.edu")
                .isEmpty()
        ) {

            User user = new User();

            user.setName("Student One");
            user.setEmail("student@college.edu");

            user.setPassword(
                    passwordEncoder.encode("1234")
            );

            user.setRole("STUDENT");

            userRepository.save(user);
        }
    }
}