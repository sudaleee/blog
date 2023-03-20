package com.leehg.blog.domain.blog.search.domain;

import lombok.EqualsAndHashCode;

@EqualsAndHashCode(onlyExplicitlyIncluded = true, callSuper = false)
public record Blog(String name, @EqualsAndHashCode.Include String url, BlogContent content) { }
