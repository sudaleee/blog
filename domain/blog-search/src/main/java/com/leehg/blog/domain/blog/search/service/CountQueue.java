package com.leehg.blog.domain.blog.search.service;

import lombok.RequiredArgsConstructor;

import java.util.concurrent.ConcurrentLinkedQueue;

@RequiredArgsConstructor
enum CountQueue {
    INSTANCE(new ConcurrentLinkedQueue<>());
    private final ConcurrentLinkedQueue<Object> queue;
}
