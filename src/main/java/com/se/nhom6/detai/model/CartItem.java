package com.se.nhom6.detai.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "cart_items")
@Data
public class CartItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    @ManyToOne
    @JoinColumn(name = "username")
    private UserDetail userDetail;

    private int quantity;

    @Transient
    public double getSubtotal() {
        return this.product.getPrice() * quantity;
    }

}
