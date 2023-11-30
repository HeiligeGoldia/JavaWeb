package com.se.nhom6.detai.controller;

import com.se.nhom6.detai.model.Product;
import com.se.nhom6.detai.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;

@Controller
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/list")
    public String listProducts(Model theModel) {
        List<Product> theProducts = productService.getAll();
        theModel.addAttribute("items", theProducts);
        return "products/list-products";
    }

    @GetMapping("/showFormForAdd")
    public String showFormForAdd(Model theModel) {
        Product theProduct = new Product();
        theModel.addAttribute("items", theProduct);
        return "products/product-form";
    }

    @GetMapping("/showFromForUpdate")
    public String showFromForUpdate(@RequestParam("itemId") int theId, Model theModel) {
        Product theProduct = productService.findById(theId);
        theModel.addAttribute("product", theProduct);

        return "products/product-form-update";

    }

    @PostMapping("/save")
    public String saveProduct(@RequestParam("itemName") String productName, @RequestParam("description") String description,
                              @RequestParam("price") double price, @RequestParam("type") String type, @RequestParam("qty") int qty, @RequestParam("brand") String brand, @RequestParam("photo") MultipartFile thephoto) {
        Product theProduct = new Product();
        theProduct.setName(productName);
        theProduct.setDescription(description);
        theProduct.setQuantityInStock(qty);
        theProduct.setPrice(price);
        theProduct.setBrand(brand);
        theProduct.setType(type);


        if (thephoto.isEmpty()) {
            return "redirect:/products/save";
        }
        Path path = Paths.get("uploads/");

        try {
            InputStream inputStream = thephoto.getInputStream();
            Files.copy(inputStream, path.resolve(thephoto.getOriginalFilename()), StandardCopyOption.REPLACE_EXISTING);
            theProduct.setImage(thephoto.getOriginalFilename().toLowerCase());
        } catch (Exception e) {
            e.printStackTrace();
        }

        productService.save(theProduct);
        return "redirect:/products/list";

    }

    @PostMapping("/update")
    public String updateProduct(@ModelAttribute("product") Product theProduct) {
        productService.save(theProduct);
        return "redirect:/products/list";

    }

    @GetMapping("/delete")
    public String delete(@RequestParam("itemId") int theId) {
        productService.deleteById(theId);
        return "redirect:/products/list";
    }

}
