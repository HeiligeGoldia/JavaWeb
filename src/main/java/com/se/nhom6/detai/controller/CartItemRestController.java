package com.se.nhom6.detai.controller;

import com.se.nhom6.detai.model.UserDetail;
import com.se.nhom6.detai.service.CartItemService;
import com.se.nhom6.detai.service.UserDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CartItemRestController {

    @Autowired
    private CartItemService cartItemService;

    @Autowired
    private UserDetailService userDetailService;

    @PostMapping("/cart/add/{pid}/{qty}")
    public String addItemToCart(@PathVariable("pid") int itemId, @PathVariable("qty") int quantity, @AuthenticationPrincipal Authentication authentication) {

        authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentPrincipalName = authentication.getName();
        UserDetail user = userDetailService.findByUsername(currentPrincipalName);

        if(user == null) {
            return "User null";
        }

        int addedQuantity = cartItemService.addItem(itemId, quantity, user);

        return "quantity: "+ addedQuantity;

    }

    @PostMapping("/cart/update/{pid}/{qty}")
    public String updateItemToCart(@PathVariable("pid") int itemId, @PathVariable("qty") int quantity, @AuthenticationPrincipal Authentication authentication) {
        authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentPrincipalName = authentication.getName();
        UserDetail user = userDetailService.findByUsername(currentPrincipalName);

        double subtotal =cartItemService.updateQuantity(itemId, quantity, user);

        return String.valueOf(subtotal);

    }

    @PostMapping("/cart/remove/{pid}")
    public String removeItemFromCart(@PathVariable("pid") int itemId, @AuthenticationPrincipal Authentication authentication) {

        authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentPrincipalName = authentication.getName();
        UserDetail user = userDetailService.findByUsername(currentPrincipalName);

        cartItemService.removeItem(itemId, user);

        return "The item have been remove from your shopping cart";

    }

}
