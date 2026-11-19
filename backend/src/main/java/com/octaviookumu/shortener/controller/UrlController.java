package com.octaviookumu.shortener.controller;

import com.octaviookumu.shortener.dto.ShortenUrlRequestDto;
import com.octaviookumu.shortener.dto.ShortenUrlResponseDto;
import com.octaviookumu.shortener.entity.UrlEntity;
import com.octaviookumu.shortener.service.UrlService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class UrlController {

    private final UrlService urlService;

    @PostMapping("/short-links") // non-idempotent
    public ShortenUrlResponseDto shortenUrl(@RequestBody ShortenUrlRequestDto requestDto) {
        // pass requestDto rather than requestDto.url() as that would defeat the purpose of using a dto
        UrlEntity savedUrlEntity = urlService.shortenUrl(requestDto);
        return new ShortenUrlResponseDto(
                savedUrlEntity.getShortCode(),
                savedUrlEntity.getMainUrl());
    }

    @GetMapping("/{shortCode}")
    public ResponseEntity<Void> getRedirectionUri(@PathVariable String shortCode) {
        return ResponseEntity.status(HttpStatus.MOVED_PERMANENTLY.value())
                .location(urlService.getDirectionUri(shortCode))
                .build();
    }

    @GetMapping("/short-links")
    public ResponseEntity<Page<ShortenUrlResponseDto>> getShortenedUrls(
            @PageableDefault(size = 10, sort = "createdAt", direction = Sort.Direction.DESC)
            Pageable pageable) {
        Page<UrlEntity> entities = urlService.getShortenedUrls(pageable);

        Page<ShortenUrlResponseDto> dtos = entities.map(entity ->
                new ShortenUrlResponseDto(entity.getShortCode(), entity.getMainUrl()));

        return ResponseEntity.ok(dtos);
    }

}

// API first design: Before writing any code, define endpoints; inputs, outputs, exception cases
