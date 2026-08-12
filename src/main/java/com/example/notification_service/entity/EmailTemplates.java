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
    @Enumerated(EnumType.STRING)
    private String name;
    @Enumerated(EnumType.STRING)
    private String subject;
    @Enumerated(EnumType.STRING)
    private String content;

}
