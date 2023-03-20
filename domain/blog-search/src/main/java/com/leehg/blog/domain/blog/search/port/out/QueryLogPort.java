package com.leehg.blog.domain.blog.search.port.out;

import com.leehg.blog.domain.blog.search.domain.QueryLog;

import java.util.List;

public interface QueryLogPort {

    void save(QueryLog log);

    void saveAll(List<QueryLog> logs);
}
