package com.serenidad.article.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.serenidad.article.entity.Article;

public interface ArticleRepository
        extends JpaRepository<Article, Long> {

    List<Article> findByPublishedTrueOrderByCreatedAtDesc();

    Optional<Article> findBySlugAndPublishedTrue(String slug);
}