package com.blog.adapter.psersist.stat.out.persistence;

import com.application.blog.search.domain.QueryLog;
import com.application.blog.search.port.out.QueryLogPort;
import com.blog.adapter.psersist.stat.domain.QueryLogEntity;
import com.blog.adapter.psersist.stat.domain.QueryLogRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
public class QueryLogAdapter implements QueryLogPort {

    private final QueryLogRepository repository;

    @Override
    @Transactional
    public void save(QueryLog log) {
        //TODO : Bulk 처리
        repository.save(QueryLogEntity.of(log));
    }
}
