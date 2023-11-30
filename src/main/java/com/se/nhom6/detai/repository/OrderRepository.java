package com.se.nhom6.detai.repository;

import com.se.nhom6.detai.model.Order;
import com.se.nhom6.detai.model.UserDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order, Integer> {

    List<Order> findByUserDetail(UserDetail userDetail);

    List<Order> findByStatus(String status);

    @Query(value = "update orders set status=:status where order_id=:order_id", nativeQuery = true)
    @Modifying
    @Transactional
    void updateOrder(@Param("status") String status, @Param("order_id") int order_id);

}