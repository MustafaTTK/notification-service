package com.example.notification_service.dto;

import jakarta.validation.constraints.NotBlank;

public record EmailTemplateCreateDto(@NotBlank(message = "Name alanı boş olamaz") String name,@NotBlank(message = "Subject alanı boş olamaz!") String subject,@NotBlank(message = "Content alanı boş olamaz") String content) {
}
