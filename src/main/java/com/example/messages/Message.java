package com.example.messages;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

public class Message {
    public static abstract class MessageRequest<T> {
        abstract public T toEntity();

        public T assignTo(T model) {
            Field[] fields = this.getClass().getDeclaredFields();
            for (Field field : fields) {
                if (!Modifier.isStatic(field.getModifiers()) && !Modifier.isFinal(field.getModifiers())) {
                    try {
                        field.set(model, field.get(this));
                    } catch (IllegalAccessException e) {
                    } catch (IllegalArgumentException e) {
                    }
                }
            }
            return model;
        }
    }

    public static abstract class MessageResponse<T> {
        public void assign(T model) {
            Field[] fields = this.getClass().getDeclaredFields();
            for (Field field : fields) {
                if (!Modifier.isStatic(field.getModifiers()) && !Modifier.isFinal(field.getModifiers())) {
                    try {
                        field.set(this, field.get(model));
                    } catch (IllegalAccessException e) {
                    } catch (IllegalArgumentException e) {
                    }
                }
            }
        }
    }
}