package com.octaviookumu.shortener.service.impl;

import com.octaviookumu.shortener.dto.ShortenUrlRequestDto;
import com.octaviookumu.shortener.entity.UrlEntity;
import com.octaviookumu.shortener.repository.UrlRepository;
import com.octaviookumu.shortener.service.UrlService;
import com.octaviookumu.shortener.util.UrlUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UrlServiceImpl implements UrlService {

    private final UrlUtils urlUtils;
    private final UrlRepository urlRepository;

    @Override
    public UrlEntity shortenUrl(ShortenUrlRequestDto requestDto) {
        var url = requestDto.url();
        boolean isValid = urlUtils.isValid(url);
        if (!isValid) {
            throw new RuntimeException("URL is invalid");
        }
        String shortCode = "TODO";
        UrlEntity urlEntity = new UrlEntity();
        urlEntity.setMainUrl(url);
        urlEntity.setShortCode(shortCode);
        return urlRepository.save(urlEntity);
    }
}
