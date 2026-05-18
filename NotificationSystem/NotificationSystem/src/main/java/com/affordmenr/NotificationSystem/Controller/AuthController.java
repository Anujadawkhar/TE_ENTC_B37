package com.affordmenr.NotificationSystem.Controller;


import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import com.affordmenr.NotificationSystem.Auth.AuthService;
import com.affordmenr.NotificationSystem.DTO.LoginRequest;
import com.affordmenr.NotificationSystem.DTO.LoginResponse;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping("/login")
    public LoginResponse login(
            @RequestBody LoginRequest request
    ) {

        String token = authService.login(request);

        return new LoginResponse(token);
    }
}