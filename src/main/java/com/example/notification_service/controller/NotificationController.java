package com.example.notification_service.controller;

import com.example.notification_service.dto.NotificationSearchDto;
import com.example.notification_service.entity.Notification;
import com.example.notification_service.enums.NotificationType;
import com.example.notification_service.service.NotificationService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/notifications")
@RequiredArgsConstructor
public class NotificationController {

    private final NotificationService notificationService;

    @PostMapping
    public Notification createNotification(@RequestBody Notification notification){
        return notificationService.createNotification(notification.getRecipient(), notification.getMessage(),notification.getType());
    }

    @PostMapping("/list")
    public ResponseEntity<List<Notification>> listNotification(@RequestBody @Valid NotificationSearchDto recipient, @RequestParam NotificationType type){
        return ResponseEntity.ok(notificationService.listNotification(recipient.recipient(),type));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Notification> getNotificationById(@PathVariable Long id) {
        return ResponseEntity.ok(notificationService.getNotificationById(id));
    }
}