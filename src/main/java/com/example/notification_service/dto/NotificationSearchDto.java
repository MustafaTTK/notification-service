package com.example.notification_service.dto;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public record NotificationSearchDto(@NotBlank(message = "Recipient alanı boş olamaz")
                                    String recipient) {
}

