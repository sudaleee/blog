package com.blog.external.naver.out.persistence;

import com.application.blog.search.domain.Blog;
import com.application.blog.search.port.out.BlogSearchPort;
import com.application.blog.search.service.ExternalError;
import com.blog.common.core.dto.SearchDto;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BlogSearchStandbyAdapter implements BlogSearchPort {
    @Override
    public Page<Blog> search(String query, SearchDto.PageReq pageReq) throws ExternalError {
        return null;
    }
}
