package com.example.messages;

import java.util.List;

import org.springframework.data.domain.Page;

public class PagedResult<T> {
    public List<T> data;

    public static <T>PagedResult<T> from(Page<T> page) {
        PagedResult<T> result = new PagedResult<>();
        result.data = page.getContent();
        return result;
    }
}