package com.application.blog.search.port.out;

import com.application.blog.search.domain.Blog;
import com.blog.common.core.dto.SearchDto;

import java.util.List;

public interface BlogSearchCachePort {
    List<Blog> search(String query, SearchDto.PageReq pageReq);

    void putCache();
}
