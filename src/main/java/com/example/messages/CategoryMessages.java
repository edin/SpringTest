package com.example.messages;

public class CategoryMessages {
    public static class CategoryRequest {
        public Long parentId;
        public String title;
        public boolean isVisible;
        public String imageUrl;
    }

    public static class CategoryResponse {
        public Long id;
        public Long parentId;
        public String title;
        public boolean isVisible;
        public String imageUrl;
    }
}


