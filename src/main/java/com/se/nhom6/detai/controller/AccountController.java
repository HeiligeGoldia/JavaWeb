package com.se.nhom6.detai.controller;

import com.se.nhom6.detai.service.AccountService;
import com.se.nhom6.detai.service.UserDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/account")
public class AccountController {

    @Autowired
    private AccountService accountService;

    @Autowired
    private UserDetailService userDetailService;

    @GetMapping("/form-create")
    public String showCreateForm(){
        return "registration";
    }

    @PostMapping("/create")
    public String createAccount(@RequestParam("username") String username, @RequestParam("password") String password,
                                @RequestParam("name") String name, @RequestParam("phone") String phone, @RequestParam("email") String email, @RequestParam("address") String address) {
        if(accountService.checkUsername(username)){
            return "redirect:/account/form-create";
        }
        accountService.createAccount(username, password, 1);
        userDetailService.create(username, name, phone, email, address);
        return "redirect:/";
    }

}
