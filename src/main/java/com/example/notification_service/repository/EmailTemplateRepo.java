package com.example.notification_service.repository;

import com.example.notification_service.entity.EmailTemplates;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface EmailTemplateRepo extends JpaRepository<EmailTemplates,Long> {
    List<EmailTemplates> findByNameContainingIgnoreCaseAndActiveTrue(String name);

    @Query("SELECT e FROM EmailTemplates e WHERE LOWER(e.name) LIKE LOWER(CONCAT('%', :name, '%')) AND e.active = true")
    List<EmailTemplates> searchActiveByName(@Param("name") String name);
}
