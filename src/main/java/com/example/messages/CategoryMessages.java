package com.example.messages;

import com.example.entity.Category;
import com.example.messages.Message.MessageRequest;
import com.example.messages.Message.MessageResponse;

public class CategoryMessages {
    public static class CategoryRequest extends MessageRequest<Category> {
        public Long parentId;
        public String title;
        public boolean isVisible;
        public String imageUrl;

        public Category toEntity() {
            return assignTo(new Category());
        }
    }

    public static class CategoryResponse  extends MessageResponse<Category> {
        public Long id;
        public Long parentId;
        public String title;
        public boolean isVisible;
        public String imageUrl;

        public static CategoryResponse from(Category model) {
            CategoryResponse result = new CategoryResponse();
            result.assign(model);
            return result;
        }
    }
}