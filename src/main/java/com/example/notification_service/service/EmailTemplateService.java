package com.example.notification_service.service;

import com.example.notification_service.dto.EmailTemplateCreateDto;
import com.example.notification_service.entity.EmailTemplates;
import com.example.notification_service.exception.NotificationNotFoundException;
import com.example.notification_service.exception.TemplateNotFoundException;
import com.example.notification_service.repository.EmailTemplateRepo;
import lombok.Builder;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class EmailTemplateService {

    private final EmailTemplateRepo emailTemplateRepo;

    public EmailTemplates createTemplate(EmailTemplateCreateDto dto){
        EmailTemplates emailTemplates = EmailTemplates.builder().name(dto.name()).content(dto.content()).subject(dto.subject()).build();
        return emailTemplateRepo.save(emailTemplates);
    }

    public EmailTemplates findTemplatesWithId(Long id){
        return emailTemplateRepo.findById(id).orElseThrow(() -> new TemplateNotFoundException("ID'si " + id + " olan bildirim bulunamadı."));
    }
}
