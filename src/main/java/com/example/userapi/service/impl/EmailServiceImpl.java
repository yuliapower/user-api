package com.example.userapi.service.impl;

import com.example.userapi.entity.Email;
import com.example.userapi.entity.User;
import com.example.userapi.exception.NotFoundException;
import com.example.userapi.repository.EmailRepository;
import com.example.userapi.service.EmailService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@Transactional
@RequiredArgsConstructor
public class EmailServiceImpl implements EmailService {

    private final EmailRepository emailRepository;

    @Override
    @Transactional(readOnly = true)
    public Email getEmailById(Long id) {

        log.info("Find email by id: {}", id);

        var email = emailRepository.findById(id).
            orElseThrow(() -> new NotFoundException("Can't find email"));

        log.info("Email with id {} successfully found", id);

        return email;
    }

    @Override
    public Email createEmail(String email, User user) {

        log.info("Creating email for user: {}", user);

        var emailEntity = new Email();

        emailEntity.setEmail(email);
        emailEntity.setUser(user);

        var savedEmail = emailRepository.save(emailEntity);

        log.info("Email with id {} successfully created", savedEmail.getId());

        return savedEmail;
    }
}
