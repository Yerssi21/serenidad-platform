package com.serenidad.specialty.entity;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OrderBy;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "specialties")
@Getter
@Setter
@NoArgsConstructor
public class Specialty {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false, length = 160)
	private String title;

	@Column(nullable = false, unique = true, length = 180)
	private String slug;

	@Column(nullable = false, length = 500)
	private String summary;

	@Column(length = 300)
	private String image;

	@Column(name = "display_order", nullable = false)
	private Integer displayOrder;

	@Column(nullable = false)
	private Boolean active;

	@Column(name = "created_at", nullable = false)
	private OffsetDateTime createdAt;

	@Column(name = "updated_at")
	private OffsetDateTime updatedAt;

	@OneToMany(mappedBy = "specialty")
	@OrderBy("displayOrder ASC")
	private List<SpecialtySection> sections = new ArrayList<>();
}