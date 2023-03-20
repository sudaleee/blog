package com.leehg.blog.domain.blog.search.port.in;

import com.leehg.blog.domain.blog.search.domain.Blog;

public record BlogResponse(String name, String url, String title, String content) {

    public static BlogResponse of(Blog blog) {
        return new BlogResponse(blog.name(), blog.url(), blog.content().title(), blog.content().content());
    }
}
