package com.example.notification_service.controller;

import com.example.notification_service.dto.NotificationSearchDto;
import com.example.notification_service.entity.Notification;
import com.example.notification_service.service.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/notifications")
public class NotificationController {

    @Autowired
    NotificationService notificationService;

    @PostMapping
    public Notification createNotification(@RequestBody Notification notification){
        return notificationService.createNotification(notification.getRecipient(), notification.getMessage(),notification.getType());
    }

    @PostMapping("/list")
    public ResponseEntity<List<Notification>> listNotification(@RequestBody NotificationSearchDto recipient){
        return ResponseEntity.ok(notificationService.listNotification(recipient.recipient()));
    }
}
