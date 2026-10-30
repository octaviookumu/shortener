package com.octaviookumu.shortener.repository;

import com.octaviookumu.shortener.entity.UrlEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UrlRepository extends JpaRepository<UrlEntity, Long> {
}
