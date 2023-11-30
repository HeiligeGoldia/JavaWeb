package com.se.nhom6.detai.model;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "orders")
@Data
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id")
    private int id;

    @ManyToOne
    @JoinColumn(name="username")
    private UserDetail userDetail;

    private LocalDate orderDate;

    private String status;

    private String payment;

}
