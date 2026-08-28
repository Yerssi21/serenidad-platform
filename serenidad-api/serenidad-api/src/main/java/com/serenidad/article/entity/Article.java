package com.serenidad.article.entity;

import java.time.OffsetDateTime;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "articles")
@Getter
@Setter
@NoArgsConstructor
public class Article {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false, length = 200)
	private String title;

	@Column(nullable = false, unique = true, length = 220)
	private String slug;

	@Column(nullable = false, length = 100)
	private String category;

	@Column(nullable = false, length = 500)
	private String excerpt;

	@Column(nullable = false, columnDefinition = "TEXT")
	private String content;

	@Column(length = 300)
	private String image;

	@Column(name = "reading_time", length = 20)
	private String readingTime;

	@Column(nullable = false)
	private Boolean published;

	@Column(name = "created_at", nullable = false)
	private OffsetDateTime createdAt;

	@Column(name = "updated_at")
	private OffsetDateTime updatedAt;
}