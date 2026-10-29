package com.octaviookumu.shortener.controller;

import com.octaviookumu.shortener.service.UrlService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class UrlController {

    private final UrlService urlService;

    @PostMapping // non-idempotent
    public String shortenUrl(String url){
    }
}

// API first design: Before writing any code, define endpoints; inputs, outputs, exception cases
