package com.serenidad.specialty.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.serenidad.specialty.dto.SpecialtyDetailResponse;
import com.serenidad.specialty.dto.SpecialtySummaryResponse;
import com.serenidad.specialty.service.SpecialtyService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/specialties")
@RequiredArgsConstructor
public class SpecialtyController {

	private final SpecialtyService specialtyService;

	@GetMapping
	public ResponseEntity<List<SpecialtySummaryResponse>> findAll() {

		return ResponseEntity.ok(specialtyService.findAll());
	}

	@GetMapping("/{slug}")
	public ResponseEntity<SpecialtyDetailResponse> findBySlug(@PathVariable String slug) {

		return ResponseEntity.ok(specialtyService.findBySlug(slug));
	}
}