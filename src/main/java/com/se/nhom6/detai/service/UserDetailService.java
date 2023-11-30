package com.se.nhom6.detai.service;

import com.se.nhom6.detai.model.UserDetail;
import com.se.nhom6.detai.repository.UserDetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserDetailService {

    @Autowired
    private UserDetailRepository userDetailRepository;

    public String create(String username, String name, String phone, String email, String address) {
        UserDetail ud = new UserDetail();
        ud.setUsername(username);
        ud.setName(name);
        ud.setPhone(phone);
        ud.setEmail(email);
        ud.setAddress(address);
        userDetailRepository.save(ud);
        return username;
    }

    public UserDetail findByEmail(String email) {
        return userDetailRepository.findByEmail(email);
    }

    public UserDetail findByPhone(String phone) {
        return userDetailRepository.findByPhone(phone);
    }

    public UserDetail findByUsername(String username) {
        return userDetailRepository.findById(username).get();
    }

    public void edit(String name, String address, String username){
        userDetailRepository.edit(name, address, username);
        System.out.println(username);
    }

}
