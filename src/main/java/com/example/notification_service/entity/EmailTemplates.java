package com.example.notification_service.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@Table(name = "EMAIL_TEMPLATES")
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EmailTemplates {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String subject;
    private String content;

}
