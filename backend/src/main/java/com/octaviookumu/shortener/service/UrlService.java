package com.octaviookumu.shortener.service;

import com.octaviookumu.shortener.dto.ShortenUrlRequestDto;
import com.octaviookumu.shortener.entity.UrlEntity;

public interface UrlService {
    UrlEntity shortenUrl(ShortenUrlRequestDto requestDto);
}
