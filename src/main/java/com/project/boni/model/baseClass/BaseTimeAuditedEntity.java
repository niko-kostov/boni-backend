package com.project.boni.model.baseClass;

import lombok.Data;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;

@Data
@MappedSuperclass
public abstract class BaseTimeAuditedEntity<U, T> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @CreatedDate
    @Column(name = "create_date")
    private T createDate;
}
