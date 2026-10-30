package com.octaviookumu.shortener.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


@Entity
@Getter
@Setter
@Table(name = "url")
public class UrlEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "mainUrl")
    private String mainUrl;

    @Column(name = "shortCode")
    private String shortCode;
}
