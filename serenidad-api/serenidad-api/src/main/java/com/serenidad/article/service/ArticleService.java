package com.serenidad.article.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.serenidad.article.dto.ArticleResponse;
import com.serenidad.article.entity.Article;
import com.serenidad.article.exception.ArticleNotFoundException;
import com.serenidad.article.repository.ArticleRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ArticleService {

	private final ArticleRepository repository;

	public List<ArticleResponse> findAllPublished() {
		return repository.findByPublishedTrueOrderByCreatedAtDesc().stream().map(this::toResponse).toList();
	}

	public ArticleResponse findBySlug(String slug) {

		Article article = repository.findBySlugAndPublishedTrue(slug)
				.orElseThrow(() -> new ArticleNotFoundException(slug));

		return toResponse(article);
	}

	private ArticleResponse toResponse(Article article) {

		return new ArticleResponse(article.getId(), article.getTitle(), article.getSlug(), article.getCategory(),
				article.getExcerpt(), article.getContent(), article.getImage(), article.getReadingTime(),
				article.getCreatedAt());
	}
}