package com.octaviookumu.shortener.service.impl;

import com.octaviookumu.shortener.dto.ShortenUrlRequestDto;
import com.octaviookumu.shortener.entity.UrlEntity;
import com.octaviookumu.shortener.repository.UrlRepository;
import com.octaviookumu.shortener.service.UrlService;
import com.octaviookumu.shortener.util.UrlUtils;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.sql.SQLIntegrityConstraintViolationException;

@Service
@RequiredArgsConstructor
public class UrlServiceImpl implements UrlService {

    private final UrlUtils urlUtils;
    private final UrlRepository urlRepository;

    @Override
    public UrlEntity shortenUrl(ShortenUrlRequestDto requestDto) {
        var url = requestDto.url();
        try{

            boolean isValid = urlUtils.isValid(url);
            if (!isValid) {
                throw new RuntimeException("URL is invalid");
            }
            String shortCode = RandomStringUtils.insecure().nextAlphanumeric(8);
            UrlEntity urlEntity = new UrlEntity();
            urlEntity.setMainUrl(url);
            urlEntity.setShortCode(shortCode);
            return urlRepository.save(urlEntity);
        }catch (DataIntegrityViolationException ex){
            // a round trip done only when the shortcode url already exists in db (SQLIntegrityConstraintViolationException)
            String shortCode = RandomStringUtils.insecure().nextAlphanumeric(8);
            UrlEntity urlEntity = new UrlEntity();
            urlEntity.setMainUrl(url);
            urlEntity.setShortCode(shortCode);
            return urlRepository.save(urlEntity);
        }
    }
}
