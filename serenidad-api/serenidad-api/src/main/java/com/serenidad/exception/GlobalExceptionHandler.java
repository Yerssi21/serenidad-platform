package com.serenidad.exception;

import java.time.OffsetDateTime;
import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.serenidad.article.exception.ArticleNotFoundException;
import com.serenidad.specialty.exception.SpecialtyNotFoundException;

@RestControllerAdvice
public class GlobalExceptionHandler {

	/*
	 * ============================ VALIDACIONES ============================
	 */

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<Map<String, Object>> handleValidation(MethodArgumentNotValidException exception) {

		Map<String, String> errors = new LinkedHashMap<>();

		exception.getBindingResult().getFieldErrors()
				.forEach(error -> errors.put(error.getField(), error.getDefaultMessage()));

		Map<String, Object> response = new LinkedHashMap<>();

		response.put("timestamp", OffsetDateTime.now());

		response.put("status", HttpStatus.BAD_REQUEST.value());

		response.put("message", "Hay errores de validación");

		response.put("errors", errors);

		return ResponseEntity.badRequest().body(response);
	}

	/*
	 * ============================ ARTÍCULO NO ENCONTRADO
	 * ============================
	 */

	@ExceptionHandler(ArticleNotFoundException.class)
	public ResponseEntity<Map<String, Object>> handleArticleNotFound(ArticleNotFoundException exception) {

		Map<String, Object> response = new LinkedHashMap<>();

		response.put("timestamp", OffsetDateTime.now());

		response.put("status", HttpStatus.NOT_FOUND.value());

		response.put("message", exception.getMessage());

		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
	}

	@ExceptionHandler(SpecialtyNotFoundException.class)
	public ResponseEntity<Map<String, Object>> handleSpecialtyNotFound(SpecialtyNotFoundException exception) {

		Map<String, Object> response = new LinkedHashMap<>();

		response.put("timestamp", OffsetDateTime.now());

		response.put("status", HttpStatus.NOT_FOUND.value());

		response.put("message", exception.getMessage());

		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
	}
}