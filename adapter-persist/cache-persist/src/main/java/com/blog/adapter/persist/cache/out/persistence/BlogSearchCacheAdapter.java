package com.blog.adapter.persist.cache.out.persistence;

import com.application.blog.search.domain.Blog;
import com.application.blog.search.port.out.BlogSearchCachePort;
import com.blog.common.core.dto.SearchDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BlogSearchCacheAdapter implements BlogSearchCachePort {
    @Override
    public List<Blog> search(String query, SearchDto.PageReq pageReq) {
        return null;
    }

    @Override
    public void putCache() {

    }
}
