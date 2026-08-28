package com.serenidad.chat.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record ChatRequestDto(

        @NotBlank(message = "El mensaje es obligatorio")
        @Size(
                max = 1200,
                message = "El mensaje no puede superar los 1200 caracteres"
        )
        String message

) {
}