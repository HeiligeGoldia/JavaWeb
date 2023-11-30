package com.se.nhom6.detai.repository;

import java.util.List;

import com.se.nhom6.detai.model.Order;
import com.se.nhom6.detai.model.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderDetailRepository extends JpaRepository<OrderDetail, Integer>{
	
	List<OrderDetail> findByOrder(Order theOrder);
	void deleteByOrder(Order theOrder);

}
