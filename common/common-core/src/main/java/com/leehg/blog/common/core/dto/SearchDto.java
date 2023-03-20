package com.leehg.blog.common.core.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.UtilityClass;

@UtilityClass
public class SearchDto {

    @Setter
    @Getter
    @NoArgsConstructor
    public static class PageReq {

        private int size;

        private int page;

        private SortOpts sortOpts;
    }
}
