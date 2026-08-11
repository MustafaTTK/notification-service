package com.example.notification_service.dto;
import jakarta.validation.constraints.NotBlank;

public record NotificationSearchDto(@NotBlank(message = "Recipient alanı boş olamaz")
                                    String recipient) {
}

