package com.example.notification_service.service;

import com.example.notification_service.entity.Notification;
import com.example.notification_service.enums.NotificationStatus;
import com.example.notification_service.enums.NotificationType;
import com.example.notification_service.exception.NotificationNotFoundException;
import com.example.notification_service.repository.NotificationRepo;
import lombok.RequiredArgsConstructor;
import org.aspectj.weaver.ast.Not;
import org.springframework.stereotype.Service;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class NotificationService {

    private final NotificationRepo notificationRepo;

    public Notification createNotification(String recipient, String message, NotificationType type) {
        Notification notification = Notification.builder().recipient(recipient).message(message).type(type).status(NotificationStatus.PENDING).build();
        return notificationRepo.save(notification);
    }

    public List<Notification> listNotification(String recipient, NotificationType type){
        return notificationRepo.findByRecipientAndType(recipient,type);
    }

    public Notification getNotificationById(Long id) {
        return notificationRepo.findById(id)
                .orElseThrow(() -> new NotificationNotFoundException("ID'si " + id + " olan bildirim bulunamadı."));
    }

}
