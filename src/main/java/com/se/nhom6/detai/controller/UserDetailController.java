package com.se.nhom6.detai.controller;

import com.se.nhom6.detai.model.UserDetail;
import com.se.nhom6.detai.service.UserDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/userinfo")
public class UserDetailController {

    @Autowired
    private UserDetailService userDetailService;

    @GetMapping("/profile")
    public String getInfo(Model theModel, @AuthenticationPrincipal Authentication authentication) {
        authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentPrincipalName = authentication.getName();
        UserDetail userDetail = userDetailService.findByUsername(currentPrincipalName);
        theModel.addAttribute("theuser", userDetail);
        return "profile";
    }

    @PostMapping("/save")
    public String updateInfo(@RequestParam("name") String name, @RequestParam("address") String address, @AuthenticationPrincipal Authentication authentication) {
        authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentPrincipalName = authentication.getName();
        userDetailService.edit(name, address, currentPrincipalName);
        return "redirect:/userinfo/profile";

    }

}
