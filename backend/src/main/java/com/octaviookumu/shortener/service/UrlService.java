package com.octaviookumu.shortener.service;

import com.octaviookumu.shortener.dto.ShortenUrlRequestDto;
import com.octaviookumu.shortener.entity.UrlEntity;

import java.net.URI;

public interface UrlService {
    UrlEntity shortenUrl(ShortenUrlRequestDto requestDto);

    URI getDirectionUri(String shortCode);
}
