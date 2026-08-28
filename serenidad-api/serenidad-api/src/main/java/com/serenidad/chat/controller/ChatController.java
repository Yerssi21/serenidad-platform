package com.serenidad.chat.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.serenidad.chat.dto.ChatRequestDto;
import com.serenidad.chat.dto.ChatResponseDto;
import com.serenidad.chat.service.ChatService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/chat")
@RequiredArgsConstructor
public class ChatController {

    private final ChatService chatService;

    @PostMapping
    public ResponseEntity<ChatResponseDto> chat(
            @Valid @RequestBody ChatRequestDto request) {

        return ResponseEntity.ok(
                chatService.chat(request)
        );
    }
}