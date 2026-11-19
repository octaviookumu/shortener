package com.octaviookumu.shortener.util;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class UrlUtilsTest {

    @Autowired
    private UrlUtils urlUtils = new UrlUtils();

    @Test
    void test_isValid() {
        assertFalse(urlUtils.isValid("spring boot diaries"));
        assertFalse(urlUtils.isValid("httpspring boot diaries"));
        assertTrue(urlUtils.isValid("https://facebook.com"));
        assertTrue(urlUtils.isValid("http://facebook.com"));
        assertFalse(urlUtils.isValid("htt://"));
        assertFalse(urlUtils.isValid(null)); // always useful to add null checks
    }

}
