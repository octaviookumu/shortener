package com.octaviookumu.shortener.service;

import com.octaviookumu.shortener.dto.ShortenUrlRequestDto;
import com.octaviookumu.shortener.entity.UrlEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.net.URI;

public interface UrlService {
    UrlEntity shortenUrl(ShortenUrlRequestDto requestDto);

    URI getDirectionUri(String shortCode);

    Page<UrlEntity> getShortenedUrls(Pageable pageable);
}
