package com.example.userapi.service.impl;

import com.example.userapi.entity.Account;
import com.example.userapi.entity.User;
import com.example.userapi.exception.NotFoundException;
import com.example.userapi.repository.AccountRepository;
import com.example.userapi.service.AccountService;
import java.util.GregorianCalendar;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@Transactional
@RequiredArgsConstructor
public class AccountServiceImpl implements AccountService {

    private final AccountRepository accountRepository;

    @Override
    @Transactional(readOnly = true)
    public Account getAccountById(Long id) {

        log.info("Find account by id: {}", id);

        var account = accountRepository.findById(id).
            orElseThrow(() -> new NotFoundException("Can't find account"));

        log.info("Account with id {} successfully found", id);

        return account;
    }

    @Override
    public Account createAccount(User user) {

        log.info("Creating account for user: {}", user);

        var account = new Account();

        account.setUser(user);
        account.setCreatedAt(GregorianCalendar.getInstance());

        var savedAccount = accountRepository.save(account);

        log.info("Account with id {} successfully created", savedAccount.getId());

        return savedAccount;
    }
}
