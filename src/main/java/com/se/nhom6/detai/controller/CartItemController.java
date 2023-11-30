package com.se.nhom6.detai.controller;

import com.se.nhom6.detai.model.CartItem;
import com.se.nhom6.detai.model.UserDetail;
import com.se.nhom6.detai.service.CartItemService;
import com.se.nhom6.detai.service.UserDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class CartItemController {

    @Autowired
    private CartItemService cartItemService;

    @Autowired
    private UserDetailService userDetailService;

    @GetMapping("/cart")
    public String showShoppingCart(Model model, @AuthenticationPrincipal Authentication authentication) {
        authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentPrincipalName = authentication.getName();
        UserDetail user = userDetailService.findByUsername(currentPrincipalName);
        List<CartItem> cartItems = cartItemService.listCartItemByUser(user);

        model.addAttribute("cartItems", cartItems);
        model.addAttribute("emailUser", currentPrincipalName);
        return "shopping-cart";
    }

}
