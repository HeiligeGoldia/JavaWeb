package com.se.nhom6.detai.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "user_details")
@Data
public class UserDetail {

    @Id
    @Column(columnDefinition = "varchar(50)")
    private String username;

    private String name;

    private String email;

    private String phone;

    private String address;

    private String avatar;

}
