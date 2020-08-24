package com.example.messages;

import java.math.BigDecimal;
import com.example.entity.Product;
import com.example.messages.Message.MessageRequest;
import com.example.messages.Message.MessageResponse;

public class ProductMessages
{
    public static class ProductRequest extends MessageRequest<Product> {
        public Long categoryId;
        public String title;
        public String description;
        public BigDecimal price;

        public Product toEntity() {
            return assignTo(new Product());
        }
    }

    public static class ProductResponse extends MessageResponse<Product> {
        public Long id;
        public Long categoryId;
        public String title;
        public String description;
        public BigDecimal price;

        public static ProductResponse from(final Product model) {
            final ProductResponse result = new ProductResponse();
            result.assign(model);
            return result;
        }
    }
}