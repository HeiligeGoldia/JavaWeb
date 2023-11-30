package com.se.nhom6.detai.controller;

import com.se.nhom6.detai.model.Order;
import com.se.nhom6.detai.model.OrderDetail;
import com.se.nhom6.detai.model.UserDetail;
import com.se.nhom6.detai.service.OrderDetailService;
import com.se.nhom6.detai.service.OrderService;
import com.se.nhom6.detai.service.UserDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class OrderController {

    @Autowired
    private OrderService orderService;

    @Autowired
    private OrderDetailService orderDetailService;

    @Autowired
    private UserDetailService userDetailService;

    @GetMapping("/orders/list")
    public String listOrders(Model theModel) {
        List<Order> theOrders = orderService.findAll();
        theModel.addAttribute("orders", theOrders);
        return "orders/list-orders";
    }

    @GetMapping("/orders_cs/list_cs")
    public String listOrders_cs(Model theModel, @AuthenticationPrincipal Authentication authentication) {
        authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentPrincipalName = authentication.getName();
        UserDetail user = userDetailService.findByUsername(currentPrincipalName);
        List<Order> theOrders = orderService.findByUser(user);
        theModel.addAttribute("orders", theOrders);
        return "orders/list-orders-cs";
    }

    @GetMapping("/orders/order_detail")
    public String showOrderDetail(@RequestParam("orderId") int theId, Model theModel) {
        Order o = new Order();
        o.setId(theId);
        List<OrderDetail> theItem = orderDetailService.findByOrder(o);
        theModel.addAttribute("items", theItem);
        theModel.addAttribute("mhd", theId);
        return "orders/orders-form-detail";
    }

    @GetMapping("/orders/done")
    public String editOrderDone(@RequestParam("orderId") int theId) {
        orderService.updateOrder("done", theId);
        return "redirect:/orders/list";
    }

    @GetMapping("/orders/processing")
    public String editOrder(@RequestParam("orderId") int theId) {
        orderService.updateOrder("processing", theId);
        return "redirect:/orders/list";
    }

}
