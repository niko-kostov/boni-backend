package com.project.boni.model;

import com.project.boni.model.baseClass.BaseTimeAuditedEntity;
import com.project.boni.model.enums.ShoppingCartStatus;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.time.ZonedDateTime;

@Data
@Entity
@Table(name = "shopping_cart")
public class ShoppingCart extends BaseTimeAuditedEntity<Long, ZonedDateTime> implements Serializable {

    @Enumerated(value = EnumType.STRING)
    @Column(name = "status")
    private ShoppingCartStatus status;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}
