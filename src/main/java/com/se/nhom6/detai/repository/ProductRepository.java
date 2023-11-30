package com.se.nhom6.detai.repository;

import com.se.nhom6.detai.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Integer> {

    @Query(value = "select * from products where name like %:name%", nativeQuery = true)
    List<Product> findByName(@Param("name") String name);

}
