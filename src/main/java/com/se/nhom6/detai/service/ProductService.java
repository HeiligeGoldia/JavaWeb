package com.se.nhom6.detai.service;

import com.se.nhom6.detai.model.Product;
import com.se.nhom6.detai.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public List<Product> getProductsByName(String name) {
        return  productRepository.findByName(name);
    }

    public List<Product> getAll() {
        return  productRepository.findAll();
    }

    public Product findById(int id) {
        return productRepository.findById(id).get();
    }

    public void save(Product theItem) {

        productRepository.save(theItem);

    }

    public void deleteById(int theId) {

        productRepository.deleteById(theId);

    }

}
