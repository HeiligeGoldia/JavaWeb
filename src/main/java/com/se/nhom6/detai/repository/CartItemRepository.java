package com.se.nhom6.detai.repository;

import java.util.List;

import com.se.nhom6.detai.model.CartItem;
import com.se.nhom6.detai.model.Product;
import com.se.nhom6.detai.model.UserDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface CartItemRepository extends JpaRepository<CartItem, Integer>{

	List<CartItem> findByUserDetail(UserDetail userDetail);

	CartItem findByUserDetailAndProduct(UserDetail userDetail, Product product);
	
	@Query(value = "update cart_items set quantity=:quantity where product_id=:product_id and username=:username", nativeQuery = true)
	@Modifying
	@Transactional
	void updateQuantity(@Param("quantity") int quantity, @Param("product_id") int product_id, @Param("username") String username);
	
	@Query(value = "delete from cart_items where username=:username and product_id=:product_id", nativeQuery = true)
	@Modifying
	@Transactional
	void deleteByUserAndProduct(@Param("username") String username, @Param("product_id") int product_id);
	
	@Query(value = "delete from cart_items where username=:username", nativeQuery = true)
	@Modifying
	@Transactional
	void deleteByUser(@Param("username") String username);
}
