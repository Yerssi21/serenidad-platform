package com.serenidad.specialty.dto;

import java.util.List;

public record SpecialtyDetailResponse(Long id, String title, String slug, String summary, String image,
		List<SpecialtySectionResponse> sections) {
}