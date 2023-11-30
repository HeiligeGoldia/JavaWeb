package com.se.nhom6.detai.controller;

import com.se.nhom6.detai.model.Product;
import com.se.nhom6.detai.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class MainController {

    @Autowired
    private ProductService productService;

    @GetMapping("/showMyLoginPage")
    public String showMyLoginPage() {
        return "login-page";
    }

    @GetMapping("/")
    public String showHome(Model theModel) {
        List<Product> theItems = productService.getAll();
        theModel.addAttribute("items", theItems);
        return "main";
    }

    @GetMapping("/getProductsByName")
    public String getProductsByName(Model theModel, @RequestParam("tensp") String tensp) {
        List<Product> theItems = productService.getProductsByName(tensp);
        theModel.addAttribute("items", theItems);
        return "main";
    }

    @GetMapping("/product_detail")
    public String showProductDetail(@RequestParam("itemId") int theId, Model theModel) {
        Product theItem = productService.findById(theId);
        theModel.addAttribute("items", theItem);

        return "products/product-form-detail";
    }

    @GetMapping("/accessdenied")
    public String showAccessDenied() {
        return "access-denied";
    }

}
