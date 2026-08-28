package com.serenidad.contact.dto;

import jakarta.validation.constraints.AssertTrue;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ContactRequestDto {

    @NotBlank(message = "El nombre es obligatorio")
    @Size(max = 120, message = "El nombre no puede superar 120 caracteres")
    private String name;

    @NotBlank(message = "El email es obligatorio")
    @Email(message = "El email no tiene un formato válido")
    @Size(max = 180)
    private String email;

    @Size(max = 30)
    private String phone;

    @NotBlank(message = "La modalidad es obligatoria")
    @Size(max = 50)
    private String modality;

    @Size(max = 500, message = "El mensaje no puede superar 500 caracteres")
    private String message;

    @AssertTrue(message = "Debes aceptar la política de privacidad")
    private boolean privacyAccepted;
}