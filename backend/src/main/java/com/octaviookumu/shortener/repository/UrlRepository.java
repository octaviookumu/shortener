package com.octaviookumu.shortener.repository;

import com.octaviookumu.shortener.entity.UrlEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface UrlRepository extends JpaRepository<UrlEntity, Long> {

    /**
     * Finds the original URL associated with the given short code.
     *
     * @param shortCode the short code to look up
     * @return the original URL, or an empty {@link Optional} if no match exists
     */
    @Query("SELECT u.mainUrl FROM UrlEntity u WHERE u.shortCode = :shortCode")
    Optional<String> findMainUrlByShortCode(@Param("shortCode") String shortCode);

}
