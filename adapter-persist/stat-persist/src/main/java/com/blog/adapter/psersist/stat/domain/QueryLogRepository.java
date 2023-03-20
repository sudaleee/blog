package com.blog.adapter.psersist.stat.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QueryLogRepository extends JpaRepository<QueryLogEntity, Long> {

}
