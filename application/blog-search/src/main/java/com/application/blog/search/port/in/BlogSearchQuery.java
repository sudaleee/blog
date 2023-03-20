package com.application.blog.search.port.in;

import org.springframework.data.domain.Page;

public interface BlogSearchQuery {

    Page<BlogResponse> search(BlogSearchCommand command);
}
