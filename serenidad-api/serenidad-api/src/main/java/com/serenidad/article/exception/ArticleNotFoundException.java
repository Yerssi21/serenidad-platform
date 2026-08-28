package com.serenidad.article.exception;

public class ArticleNotFoundException extends RuntimeException {

    public ArticleNotFoundException(String slug) {
        super("No se encontró el artículo: " + slug);
    }
}