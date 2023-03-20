package com.blog.external.kakao.domain;

import com.fasterxml.jackson.annotation.JsonAnySetter;

public class KakaoBlogMeta {

    @JsonAnySetter
    private long total_count;

}
