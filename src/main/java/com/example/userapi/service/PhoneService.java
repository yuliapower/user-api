package com.example.userapi.service;

import com.example.userapi.entity.Phone;
import com.example.userapi.entity.User;

public interface PhoneService {

    Phone getPhoneById(Long id);

    Phone createPhone(String phone, User user);
}
