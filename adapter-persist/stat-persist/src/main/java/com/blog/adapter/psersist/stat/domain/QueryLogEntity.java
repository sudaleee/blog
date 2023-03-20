package com.blog.adapter.psersist.stat.domain;

import com.application.blog.search.domain.QueryLog;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "query_log")
@NoArgsConstructor
public class QueryLogEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String query;

    @Column(name = "created_date")
    private Long createdDate;

    QueryLogEntity(String query, long createdDate) {
        this.query = query;
        this.createdDate = createdDate;
    }

    public static QueryLogEntity of(QueryLog log) {
        return new QueryLogEntity(log.query(), log.date());
    }
}
