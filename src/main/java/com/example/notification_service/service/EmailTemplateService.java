package com.example.notification_service.service;

import com.example.notification_service.dto.EmailTemplateCreateDto;
import com.example.notification_service.dto.EmailTemplateResponseDTO;
import com.example.notification_service.entity.EmailTemplates;
import com.example.notification_service.exception.TemplateNotFoundException;
import com.example.notification_service.repository.EmailTemplateRepo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import java.util.stream.Collectors;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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
        return emailTemplateRepo.findById(id).orElseThrow(() -> new TemplateNotFoundException("ID'si " + id + " olan şablon bulunamadı."));
    }

    public List<EmailTemplateResponseDTO> getAllTemplates(){
        List<EmailTemplateResponseDTO> emailTemplateResponseDTO = emailTemplateRepo.findAll().stream().map(template->new EmailTemplateResponseDTO(template.getId(),template.getName(),template.getSubject(),template.getContent())).toList();
        return emailTemplateResponseDTO;
    }

    public List<EmailTemplateResponseDTO> getAllCriteriaTemplates(String keyword){
        List<EmailTemplateResponseDTO> emailTemplateResponseDTOS = emailTemplateRepo.findAll().stream().filter(template->template.getContent().toLowerCase().contains(keyword)).map(template->new EmailTemplateResponseDTO(template.getId(), template.getName(), template.getSubject(), template.getContent())).toList();
        return  emailTemplateResponseDTOS;
    }

    //getAllCriteriaTemplates alternatifi
    public List<EmailTemplateResponseDTO> getAllCriteriaTemplates2(String keyword){
        List<EmailTemplates> emailTemplates = emailTemplateRepo.findAll();
        List<EmailTemplates> cleanTemplates = new ArrayList<>();
        for(EmailTemplates emailTemplates1:emailTemplates){
            if (emailTemplates1.getContent().contains(keyword)){
                cleanTemplates.add(emailTemplates1);
            }
        }
        List<EmailTemplateResponseDTO> emailTemplateResponseDTOS = cleanTemplates.stream().map(templates-> new EmailTemplateResponseDTO(templates.getId(), templates.getName(), templates.getSubject(), templates.getContent())).toList();
        return  emailTemplateResponseDTOS;

    }

    public List<String> getSubjectsByKeyword(String keyword){
        List<String> subjectList = emailTemplateRepo.findAll().stream().filter(template-> template.getSubject().contains(keyword)).map(template-> template.getSubject()).toList();
        return subjectList;
    }

    public EmailTemplateResponseDTO getFirstTemplateBySubject(String subject){
        EmailTemplateResponseDTO emailTemplates = emailTemplateRepo.findAll().stream().filter(template->template.getSubject().contains(subject)).map(template->new EmailTemplateResponseDTO(template.getId(), template.getName(), template.getSubject(), template.getContent())).findFirst().orElseThrow(()->new TemplateNotFoundException("Bu konuyla eşleşen şablon bulunamadı: " + subject));
        return emailTemplates;
    }

    public boolean existsByName(String name){
        return emailTemplateRepo.findAll().stream().anyMatch(template->template.getName().equalsIgnoreCase(name));
    }

    public Map<String,EmailTemplateResponseDTO> getTemplatesAsMap(){
        return emailTemplateRepo.findAll().stream().collect(Collectors.toMap(t->t.getName(),t->new EmailTemplateResponseDTO(t.getId(),t.getName(),t.getSubject(),t.getContent())));
    }
}
