package com.serenidad.contact.service;

import java.time.OffsetDateTime;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.serenidad.contact.dto.ContactRequestDto;
import com.serenidad.contact.dto.ContactResponseDto;
import com.serenidad.contact.entity.ContactRequest;
import com.serenidad.contact.repository.ContactRequestRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ContactService {

	private final ContactRequestRepository repository;

	@Transactional
	public ContactResponseDto create(ContactRequestDto dto) {

		OffsetDateTime now = OffsetDateTime.now();

		ContactRequest contact = new ContactRequest();

		contact.setName(dto.getName().trim());
		contact.setEmail(dto.getEmail().trim().toLowerCase());
		contact.setPhone(normalizeNullable(dto.getPhone()));
		contact.setModality(dto.getModality());
		contact.setMessage(normalizeNullable(dto.getMessage()));

		contact.setPrivacyAccepted(dto.isPrivacyAccepted());
		contact.setPrivacyAcceptedAt(now);

		contact.setStatus("PENDING");
		contact.setCreatedAt(now);

		ContactRequest saved = repository.save(contact);

		return new ContactResponseDto(saved.getId(), "Solicitud recibida correctamente", saved.getCreatedAt());
	}

	private String normalizeNullable(String value) {

		if (value == null || value.isBlank()) {
			return null;
		}

		return value.trim();
	}
}