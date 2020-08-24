package com.example.entity.base;

import java.time.LocalDateTime;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(
        value = {"createdAt", "updatedAt"},
        allowGetters = true
)
public abstract class AuditEntity extends CustomEntity {
    @Column(name = "createdat", nullable = false, updatable = false)
    @CreatedDate
    public LocalDateTime createdAt;

    @Column(name = "updatedat", nullable = false)
    @LastModifiedDate
    public LocalDateTime updatedAt;


    @PrePersist
    public void onPrePersist() {
        this.createdAt = LocalDateTime.now();
    }

    @PreUpdate
    public void onPreUpdate() {
        this.updatedAt = LocalDateTime.now();
    }
}