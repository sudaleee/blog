package com.leehg.blog.domain.blog.search.port.out;

import com.leehg.blog.common.core.dto.SearchDto;
import com.leehg.blog.domain.blog.search.domain.Blog;
import com.leehg.blog.domain.blog.search.service.ExternalError;
import org.springframework.data.domain.Page;

public interface BlogSearchPort {
    Page<Blog> search(String query, SearchDto.PageReq pageReq) throws ExternalError;
}
