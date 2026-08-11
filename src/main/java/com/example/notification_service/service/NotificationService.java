package com.example.notification_service.service;

import com.example.notification_service.entity.Notification;
import com.example.notification_service.repository.NotificationRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Slf4j
@Service
public class NotificationService {

    @Autowired
    NotificationRepo notificationRepo;

    public Notification createNotification(String recipient, String message, String type) {
        Notification notification = Notification.builder().recipient(recipient).message(message).type(type).status("PENDING").build();
        return notificationRepo.save(notification);
    }

    public List<Notification> listNotification(String recipient, String tpye){
        return notificationRepo.findByRecipientAndType(recipient,tpye);
    }

}
