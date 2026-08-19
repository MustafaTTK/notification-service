package com.example.notification_service.service;

import com.example.notification_service.dto.TemplateDetailDTO;
import com.example.notification_service.entity.TemplateDetail;
import com.example.notification_service.repository.TemplateDetailRepo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class TemplateDetailService {
    private final TemplateDetailRepo templateDetailRepo;

    public List<TemplateDetailDTO> findTemplates(){
        return templateDetailRepo.findAll().stream().map(template-> new TemplateDetailDTO(template.getContent(), template.getFromAddress(), template.getFromAddressId())).toList();
    }

    public TemplateDetail createTemplateDetail(String content, String fromAddress, String fromAddressId, String targetAddress ){
        TemplateDetail templateDetail = TemplateDetail.builder().content(content).fromAddress(fromAddress).targetAddress(targetAddress).fromAddressId(fromAddressId).build();
        return templateDetail;
    }

}
