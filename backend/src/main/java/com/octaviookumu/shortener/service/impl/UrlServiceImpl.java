package com.octaviookumu.shortener.service.impl;

import com.octaviookumu.shortener.service.UrlService;
import com.octaviookumu.shortener.util.UrlUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UrlServiceImpl implements UrlService {

    private final UrlUtils urlUtils;

    @Override
    public String shortenUrl(String url) {
        boolean isValid = urlUtils.isValid(url);
        if (!isValid) {
            throw new RuntimeException("URL is invalid");
        }
        // generate unique short code - will be the most complex engineering tradeoff. will need an entity and repository implemented
        // persist to database
        // return meaningful data
        return "";
    }
}
