package com.serenidad.article.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.serenidad.article.dto.ArticleResponse;
import com.serenidad.article.service.ArticleService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/articles")
@RequiredArgsConstructor
public class ArticleController {

    private final ArticleService service;

    @GetMapping
    public ResponseEntity<List<ArticleResponse>> findAll() {

        return ResponseEntity.ok(
                service.findAllPublished()
        );
    }

    @GetMapping("/{slug}")
    public ResponseEntity<ArticleResponse> findBySlug(
            @PathVariable String slug
    ) {

        return ResponseEntity.ok(
                service.findBySlug(slug)
        );
    }
}