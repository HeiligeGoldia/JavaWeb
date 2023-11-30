package com.se.nhom6.detai.service;

import com.se.nhom6.detai.model.Order;
import com.se.nhom6.detai.model.OrderDetail;
import com.se.nhom6.detai.repository.OrderDetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderDetailService {

    @Autowired
    private OrderDetailRepository orderDetailRepository;

    public List<OrderDetail> findByOrder(Order theOrder) {
        return orderDetailRepository.findByOrder(theOrder);
    }

    public void save(OrderDetail theOrderDetail) {
        orderDetailRepository.save(theOrderDetail);
    }

    public void deleteByOrder(Order theOrder) {
        orderDetailRepository.deleteByOrder(theOrder);
    }

}
