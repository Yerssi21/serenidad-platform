package com.serenidad.contact.dto;

import java.time.OffsetDateTime;

public record ContactResponseDto(
        Long id,
        String message,
        OffsetDateTime createdAt
) {
}