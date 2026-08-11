package com.example.notification_service.repository;

import com.example.notification_service.entity.Notification;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface NotificationRepo extends JpaRepository<Notification, Long> {
    List<Notification> findByRecipientAndType(String recipient, String type);
}
