package com.se.nhom6.detai.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "products")
@Data
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
    private Integer id;

    private String name;

    private Double price;

    private String type;

    private String brand;

    private String image;

    private Integer quantityInStock;

    private String description;

}