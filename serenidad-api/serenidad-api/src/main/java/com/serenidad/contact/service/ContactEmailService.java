package com.serenidad.contact.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.serenidad.contact.entity.ContactRequest;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class ContactEmailService {

	private final JavaMailSender mailSender;

	@Value("${spring.mail.username}")
	private String sender;

	@Value("${serenidad.mail.recipient}")
	private String recipient;

	public void sendNewContactNotification(ContactRequest request) {

		try {
			SimpleMailMessage email = new SimpleMailMessage();

			email.setFrom(sender);
			email.setTo(recipient);
			email.setSubject("Nueva solicitud de contacto - Serenidad");

			email.setText("""
					Se ha recibido una nueva solicitud desde Serenidad.

					Nombre: %s
					Email: %s
					Teléfono: %s
					Modalidad: %s

					La solicitud ha quedado registrada correctamente en el sistema.
					""".formatted(request.getName(), request.getEmail(), valueOrNotProvided(request.getPhone()),
					request.getModality()));

			mailSender.send(email);

			log.info("Notificación de contacto enviada correctamente. Solicitud id={}", request.getId());

		} catch (MailException exception) {

			/*
			 * El fallo del correo NO debe impedir que la solicitud quede guardada en
			 * PostgreSQL.
			 */
			log.error("No se pudo enviar la notificación de la solicitud id={}", request.getId(), exception);
		}
	}

	private String valueOrNotProvided(String value) {
		return value == null || value.isBlank() ? "No proporcionado" : value;
	}
}