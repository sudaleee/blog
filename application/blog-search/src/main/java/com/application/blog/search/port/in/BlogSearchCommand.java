package com.application.blog.search.port.in;

import com.application.blog.search.domain.QueryLog;
import com.blog.common.core.dto.SearchDto;
import com.blog.common.core.utils.DateUtils;

public record BlogSearchCommand(String query, SearchDto.PageReq pageReq) {

    public QueryLog toLog() {
        return new QueryLog(query, DateUtils.getCurrentDateUtc());
    }
}
