package com.se.nhom6.detai.service;

import com.se.nhom6.detai.model.CartItem;
import com.se.nhom6.detai.model.Product;
import com.se.nhom6.detai.model.UserDetail;
import com.se.nhom6.detai.repository.CartItemRepository;
import com.se.nhom6.detai.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartItemService {

    @Autowired
    private CartItemRepository cartItemRepository;

    @Autowired
    private ProductRepository productRepository;

    public List<CartItem> listCartItemByUser(UserDetail user){
        return cartItemRepository.findByUserDetail(user);
    }

    public int addItem(int productId, int quantity, UserDetail user) {

        int addedQuantity = quantity;

        Product product =  productRepository.findById(productId).get();

        CartItem cartItem = cartItemRepository.findByUserDetailAndProduct(user, product);

        if(cartItem != null) {
            addedQuantity = cartItem.getQuantity() + quantity;
            cartItem.setQuantity(addedQuantity);
        }else {
            cartItem = new CartItem();
            cartItem.setQuantity(quantity);
            cartItem.setUserDetail(user);
            cartItem.setProduct(product);
        }
        cartItemRepository.save(cartItem);

        System.out.println("alo 1234" + cartItem);

        return addedQuantity;

    }

    public double updateQuantity(int productId, int quantity, UserDetail user) {
        cartItemRepository.updateQuantity(quantity, productId, user.getUsername());
        Product product = productRepository.findById(productId).get();

        double subtotal = product.getPrice() * quantity;
        return subtotal ;
    }

    public void removeItem(int productId, UserDetail user) {

        cartItemRepository.deleteByUserAndProduct(user.getUsername(), productId);

    }

    public void removeAllByUser(UserDetail user) {

        cartItemRepository.deleteByUser(user.getUsername());

    }

}
