package com.affordmenr.NotificationSystem.DTO;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class NotificationRequest {

    @NotBlank
    private String studentId;

    @NotBlank
    private String type;

    @NotBlank
    private String message;
}