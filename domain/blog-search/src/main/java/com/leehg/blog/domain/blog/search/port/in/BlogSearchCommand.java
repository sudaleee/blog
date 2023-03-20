package com.leehg.blog.domain.blog.search.port.in;

import com.leehg.blog.common.core.dto.SearchDto;
import com.leehg.blog.common.core.utils.DateUtils;
import com.leehg.blog.domain.blog.search.domain.QueryLog;

public record BlogSearchCommand(String query, SearchDto.PageReq pageReq) {

    public QueryLog toLog() {
        return new QueryLog(query, DateUtils.getCurrentDateUtc());
    }
}
