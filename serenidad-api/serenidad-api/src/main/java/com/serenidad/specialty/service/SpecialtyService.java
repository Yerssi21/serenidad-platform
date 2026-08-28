package com.serenidad.specialty.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.serenidad.specialty.dto.SpecialtyDetailResponse;
import com.serenidad.specialty.dto.SpecialtySectionResponse;
import com.serenidad.specialty.dto.SpecialtySummaryResponse;
import com.serenidad.specialty.entity.Specialty;
import com.serenidad.specialty.exception.SpecialtyNotFoundException;
import com.serenidad.specialty.repository.SpecialtyRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class SpecialtyService {

	private final SpecialtyRepository repository;

	public List<SpecialtySummaryResponse> findAll() {

		return repository.findByActiveTrueOrderByDisplayOrderAsc().stream().map(this::toSummary).toList();
	}

	public SpecialtyDetailResponse findBySlug(String slug) {

		Specialty specialty = repository.findBySlugAndActiveTrue(slug)
				.orElseThrow(() -> new SpecialtyNotFoundException(slug));

		return toDetail(specialty);
	}

	private SpecialtySummaryResponse toSummary(Specialty specialty) {

		return new SpecialtySummaryResponse(specialty.getId(), specialty.getTitle(), specialty.getSlug(),
				specialty.getSummary(), specialty.getImage());
	}

	private SpecialtyDetailResponse toDetail(Specialty specialty) {

		List<SpecialtySectionResponse> sections = specialty.getSections().stream()
				.map(section -> new SpecialtySectionResponse(section.getTitle(), section.getContent(),
						section.getDisplayOrder()))
				.toList();

		return new SpecialtyDetailResponse(specialty.getId(), specialty.getTitle(), specialty.getSlug(),
				specialty.getSummary(), specialty.getImage(), sections);
	}
}