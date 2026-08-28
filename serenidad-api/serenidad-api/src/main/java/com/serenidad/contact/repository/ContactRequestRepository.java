package com.serenidad.contact.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.serenidad.contact.entity.ContactRequest;

public interface ContactRequestRepository
        extends JpaRepository<ContactRequest, Long> {
}