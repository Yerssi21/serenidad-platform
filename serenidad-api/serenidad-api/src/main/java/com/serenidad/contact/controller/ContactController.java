package com.serenidad.contact.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.serenidad.contact.dto.ContactRequestDto;
import com.serenidad.contact.dto.ContactResponseDto;
import com.serenidad.contact.service.ContactService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/contact")
@RequiredArgsConstructor
public class ContactController {

    private final ContactService service; 

    @PostMapping
    public ResponseEntity<ContactResponseDto> create(
            @Valid @RequestBody ContactRequestDto request) {

        ContactResponseDto response = service.create(request);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(response);
    }
}