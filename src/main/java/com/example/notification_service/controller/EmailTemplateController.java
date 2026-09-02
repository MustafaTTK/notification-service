package com.example.notification_service.controller;

import com.example.notification_service.dto.EmailTemplateCreateDto;
import com.example.notification_service.dto.EmailTemplateResponseDTO;
import com.example.notification_service.entity.EmailTemplates;
import com.example.notification_service.service.EmailTemplateService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/email-templates")
@RequiredArgsConstructor
public class EmailTemplateController {

    private final EmailTemplateService emailTemplateService;

    @PostMapping
    public ResponseEntity<EmailTemplates> createTemplates(@RequestBody @Valid EmailTemplateCreateDto dto){
        return ResponseEntity.ok(emailTemplateService.createTemplate(dto));
    }

    @GetMapping("/{id}")
    public ResponseEntity<EmailTemplates> findByIdTemplates(@PathVariable Long id){
        return ResponseEntity.ok(emailTemplateService.findTemplatesWithId(id));
    }

    @GetMapping
    public ResponseEntity<List<EmailTemplateResponseDTO>> listTemplates(){
        return ResponseEntity.ok(emailTemplateService.getAllTemplates());
    }

    @GetMapping("/search")
    public ResponseEntity<List<EmailTemplateResponseDTO>> listKeywordContent(@RequestParam String kewyord){
        return ResponseEntity.ok(emailTemplateService.getAllCriteriaTemplates(kewyord));
    }

    @GetMapping("/searchActive")
    public ResponseEntity<List<EmailTemplateResponseDTO>> searchTemplates(@RequestParam String name){
        return ResponseEntity.ok(emailTemplateService.searchNameActive(name));
    }
}
