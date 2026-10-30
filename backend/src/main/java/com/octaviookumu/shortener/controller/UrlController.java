package com.octaviookumu.shortener.controller;

import com.octaviookumu.shortener.dto.ShortenUrlRequestDto;
import com.octaviookumu.shortener.dto.ShortenUrlResponseDto;
import com.octaviookumu.shortener.entity.UrlEntity;
import com.octaviookumu.shortener.service.UrlService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class UrlController {

    private final UrlService urlService;

    @PostMapping("/shorten") // non-idempotent
    public ShortenUrlResponseDto shortenUrl(@RequestBody ShortenUrlRequestDto requestDto) {
        // pass requestDto rather than requestDto.url() as that would defeat the purpose of using a dto
        UrlEntity savedUrlEntity = urlService.shortenUrl(requestDto);
        return new ShortenUrlResponseDto(savedUrlEntity.getShortCode());
    }
}

// API first design: Before writing any code, define endpoints; inputs, outputs, exception cases
