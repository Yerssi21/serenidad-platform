package com.serenidad.specialty.exception;

public class SpecialtyNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public SpecialtyNotFoundException(String slug) {
		super("No se encontró la especialidad: " + slug);
	}
}