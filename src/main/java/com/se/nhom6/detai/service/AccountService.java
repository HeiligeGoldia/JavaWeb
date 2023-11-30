package com.se.nhom6.detai.service;

import com.se.nhom6.detai.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AccountService {

    @Autowired
    private AccountRepository accountRepository;

    public String createAccount(String username, String password, int enabled) {
        String ep = new BCryptPasswordEncoder().encode(password);
        String passwordData = "{bcrypt}" + ep;
        accountRepository.createAccount(username, passwordData, enabled);
        accountRepository.setRole(username);
        return username;
    }

    public boolean checkUsername(String username) {
        return accountRepository.existsById(username);
    }

}
