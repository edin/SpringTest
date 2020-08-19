package com.example.messages;

import java.util.List;

import org.springframework.data.domain.Page;

public class PaginationMessages
{
    public static class Pagination {
        public long total;
        public long currentPage;
        public long lastPage;
        public long perPage;
        public long from;
        public long to;
    }

    public static class Sort {
    }

    public static class PagedResult<T> {
        public List<T> data;
        public Pagination pagination;

        public static <T>PagedResult<T> from(Page<T> page) {
            PagedResult<T> result = new PagedResult<>();
            result.data = page.getContent();
            result.pagination = new Pagination();
            return result;
        }
    }
}