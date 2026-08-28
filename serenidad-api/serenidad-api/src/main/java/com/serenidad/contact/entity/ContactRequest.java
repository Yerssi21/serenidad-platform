package com.serenidad.contact.entity;

import java.time.OffsetDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "contact_requests")
@Getter
@Setter
@NoArgsConstructor
public class ContactRequest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 120)
    private String name;

    @Column(nullable = false, length = 180)
    private String email;

    @Column(length = 30)
    private String phone;

    @Column(nullable = false, length = 50)
    private String modality;

    @Column(length = 500)
    private String message;

    @Column(name = "privacy_accepted", nullable = false)
    private Boolean privacyAccepted;

    @Column(name = "privacy_accepted_at", nullable = false)
    private OffsetDateTime privacyAcceptedAt;

    @Column(nullable = false, length = 30)
    private String status;

    @Column(name = "created_at", nullable = false)
    private OffsetDateTime createdAt;
}