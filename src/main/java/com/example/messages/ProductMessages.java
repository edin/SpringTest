package com.example.messages;

import java.math.BigDecimal;
import com.example.entity.Product;

public class ProductMessages
{
    public static class ProductRequest {
        public Long categoryId;
        public String title;
        public String description;
        public BigDecimal price;

        public Product asProduct() {
            final Product model = new Product();
            return assignTo(model);
        }

        public Product assignTo(final Product model) {
            model.categoryId = categoryId;
            model.title = title;
            model.description = description;
            model.price = price;
            return model;
        }
    }

    public static class ProductResponse {
        public Long id;
        public Long categoryId;
        public String title;
        public String description;
        public BigDecimal price;

        public static ProductResponse from(final Product model) {
            final ProductResponse result = new ProductResponse();
            result.id = model.id;
            result.categoryId = model.categoryId;
            result.title = model.title;
            result.description = model.description;
            result.price = model.price;
            return result;
        }
    }
}