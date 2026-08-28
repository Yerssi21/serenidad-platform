package com.serenidad.article.dto;

import java.time.OffsetDateTime;

public record ArticleResponse(
        Long id,
        String title,
        String slug,
        String category,
        String excerpt,
        String content,
        String image,
        String readingTime,
        OffsetDateTime createdAt
) {
}