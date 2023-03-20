package com.application.blog.search.port.out;

import com.application.blog.search.domain.QueryLog;

public interface QueryLogPort {

    void save(QueryLog log);
}
