package com.leehg.blog.domain.blog.search.service;

import com.leehg.blog.domain.blog.search.domain.Blog;
import com.leehg.blog.domain.blog.search.port.in.BlogResponse;
import com.leehg.blog.domain.blog.search.port.in.BlogSearchCommand;
import com.leehg.blog.domain.blog.search.port.in.BlogSearchQuery;
import com.leehg.blog.domain.blog.search.port.out.BlogSearchPort;
import com.leehg.blog.domain.blog.search.port.out.QueryLogPort;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Slf4j
@Service
@RequiredArgsConstructor
class BlogSearchService implements BlogSearchQuery {

    private final BlogSearchPort activeSearchPort;

    private final BlogSearchPort backupSearchPort;

    private final QueryLogPort queryLogPort;

    @Override
    @Cacheable(cacheManager = "blogSearchCache", key = "#query")
    public Page<BlogResponse> search(BlogSearchCommand command) {

        Page<Blog> result = searchBlogByPort(command);

        //TODO: bulk??
        queryLogPort.save(command.toLog());

        return new PageImpl<>(
            convertResponse(result.getContent()),
            PageRequest.of(command.pageReq().getPage(), command.pageReq().getSize()),
            result.getTotalElements()
        );
    }

    private Page<Blog> searchBlogByPort(BlogSearchCommand command) {
        try {
            return activeSearchPort.search(command.query(), command.pageReq());
        } catch (ExternalError e) {
            log.error("error occurred in active port");
            return backupSearchPort.search(command.query(), command.pageReq());
        }
    }

    private List<BlogResponse> convertResponse(List<Blog> blogs) {

        return blogs
            .stream()
            .map(BlogResponse::of)
            .collect(Collectors.toList());
    }
}
