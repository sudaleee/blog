package com.application.blog.search.service;

import com.application.blog.search.domain.Blog;
import com.application.blog.search.port.in.BlogResponse;
import com.application.blog.search.port.in.BlogSearchCommand;
import com.application.blog.search.port.in.BlogSearchQuery;
import com.application.blog.search.port.out.BlogSearchCachePort;
import com.application.blog.search.port.out.BlogSearchPort;
import com.application.blog.search.port.out.QueryLogPort;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
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

    private final BlogSearchCachePort blogSearchCachePort;

    private final BlogSearchPort blogSearchActiveAdapter;

    private final BlogSearchPort backupSearchStandbyAdapter;

    private final QueryLogPort queryLogPort;

    @Override
    public Page<BlogResponse> search(BlogSearchCommand command) {

        //log 생성
        queryLogPort.save(command.toLog());

        //cache 에서 조회
        List<Blog> resultInCache = blogSearchCachePort.search(null, null);

        if(!resultInCache.isEmpty()) {
            return convertResponse(command, null);
        }

        //외부에서 조회
        Page<Blog> resultInExternal = searchBlogInExternal(command);

        //cache 업데이트
        blogSearchCachePort.putCache();

        //결과 리턴
        return convertResponse(command, resultInExternal);
    }

    private Page<Blog> searchBlogInExternal(BlogSearchCommand command) {
        try {
            return blogSearchActiveAdapter.search(command.query(), command.pageReq());
        } catch (ExternalError e) {
            log.error("error occurred in active port");
            return backupSearchStandbyAdapter.search(command.query(), command.pageReq());
        }
    }

    private PageImpl<BlogResponse> convertResponse(BlogSearchCommand command, Page<Blog> result) {

        List<BlogResponse> blogResponses = result
                .stream()
                .map(BlogResponse::of)
                .collect(Collectors.toList());

        return new PageImpl<>(
                blogResponses,
                PageRequest.of(command.pageReq().getPage(), command.pageReq().getSize()),
                result.getTotalElements()
        );
    }

}
