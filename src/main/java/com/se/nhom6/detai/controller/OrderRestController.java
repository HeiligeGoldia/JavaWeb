package com.se.nhom6.detai.controller;

import com.se.nhom6.detai.model.*;
import com.se.nhom6.detai.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;

@RestController
public class OrderRestController {

    @Autowired
    private OrderService orderService;

    @Autowired
    private OrderDetailService orderDetailService;

    @Autowired
    private CartItemService cartItemService;

    @Autowired
    private UserDetailService userDetailService;

    @Autowired
    private ProductService productService;

    @PostMapping("/addOrder")
    public String saveOrder(@AuthenticationPrincipal Authentication authentication) {
        authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentPrincipalName = authentication.getName();
        UserDetail user = userDetailService.findByUsername(currentPrincipalName);

        List<CartItem> itemsInCart = cartItemService.listCartItemByUser(user);
        System.out.println(itemsInCart.size());

        Order theOrder = new Order();
        theOrder.setUserDetail(user);
        theOrder.setPayment("COD");
        theOrder.setOrderDate(LocalDate.now());
        theOrder.setStatus("pending");
        orderService.save(theOrder);

        for(CartItem ci : itemsInCart) {
            Product p = productService.findById(ci.getProduct().getId());
            OrderDetail theOrderDetail = new OrderDetail();
            theOrderDetail.setOrder(theOrder);
            theOrderDetail.setProduct(p);
            theOrderDetail.setQuantity(ci.getQuantity());
            orderDetailService.save(theOrderDetail);
        }

        cartItemService.removeAllByUser(user);

        return "redirect:/";
    }

}
