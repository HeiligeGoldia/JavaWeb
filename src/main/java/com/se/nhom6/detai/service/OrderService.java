package com.se.nhom6.detai.service;

import com.se.nhom6.detai.model.Order;
import com.se.nhom6.detai.model.UserDetail;
import com.se.nhom6.detai.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    public List<Order> findAll() {
        return orderRepository.findAll();
    }

    public Order findById(int theId) {
        Optional<Order> result = orderRepository.findById(theId);
        Order theOrder = null;
        if(result.isPresent()) {
            theOrder= result.get();
        }else {
            throw new RuntimeException("Did not find order id:" +theId);
        }
        return theOrder;
    }

    public List<Order> findByUser(UserDetail theUser) {
        return orderRepository.findByUserDetail(theUser);
    }

    public List<Order> findByStatus(String theStatus) {
        return orderRepository.findByStatus(theStatus);
    }

    public void save(Order theOrder) {
        orderRepository.save(theOrder);
    }

    public void deleteById(int theId) {
        orderRepository.deleteById(theId);
    }

    public void updateOrder(String status, int theId) {
        orderRepository.updateOrder(status, theId);
    }

}
