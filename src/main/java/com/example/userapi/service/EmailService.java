package com.example.userapi.service;

import com.example.userapi.entity.Email;
import com.example.userapi.entity.User;

public interface EmailService {

    Email getEmailById(Long id);

    Email createEmail(String email, User user);
}
