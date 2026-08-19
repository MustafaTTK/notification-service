package com.example.notification_service.controller;

import com.example.notification_service.dto.TemplateDetailDTO;
import com.example.notification_service.entity.TemplateDetail;
import com.example.notification_service.service.TemplateDetailService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/template-detail")
@RequiredArgsConstructor
public class TemplateDetailController {

    TemplateDetailService templateDetailService;

    @PostMapping
    public ResponseEntity<List<TemplateDetailDTO>> findAllTemplates(){
        return ResponseEntity.ok(templateDetailService.findTemplates());
    }

    @PostMapping("/create")
    public ResponseEntity<TemplateDetail> createTemplateDetail(String content, String fromAddress, String fromAddressId, String toAddress){
        return ResponseEntity.ok(templateDetailService.createTemplateDetail(content,fromAddress,fromAddressId,toAddress));
    }

}
