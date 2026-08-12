package com.example.notification_service.repository;

import com.example.notification_service.entity.EmailTemplates;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmailTemplateRepo extends JpaRepository<EmailTemplates,Long> {
}
