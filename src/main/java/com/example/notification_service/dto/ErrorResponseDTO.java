package com.example.notification_service.dto;

import java.time.LocalDateTime;

public record ErrorResponseDTO(int status, LocalDateTime timestamp, String error, String message) {
}
