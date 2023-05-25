package com.example.userapi.service;

import com.example.userapi.entity.Account;
import com.example.userapi.entity.User;

public interface AccountService {

    Account getAccountById(Long id);

    Account createAccount(User user);
}
