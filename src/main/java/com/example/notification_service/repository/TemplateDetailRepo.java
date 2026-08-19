package com.example.notification_service.repository;

import com.example.notification_service.entity.TemplateDetail;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TemplateDetailRepo extends JpaRepository<TemplateDetail,Long> {
}
