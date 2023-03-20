package com.application.blog.search.port.out;

import com.application.blog.search.domain.Blog;
import com.application.blog.search.service.ExternalError;
import com.blog.common.core.dto.SearchDto;
import org.springframework.data.domain.Page;

public interface BlogSearchPort {
    Page<Blog> search(String query, SearchDto.PageReq pageReq) throws ExternalError;
}
