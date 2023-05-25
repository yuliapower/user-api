package com.example.userapi.service.impl;

import com.example.userapi.entity.User;
import com.example.userapi.exception.NotFoundException;
import com.example.userapi.entity.Phone;
import com.example.userapi.repository.PhoneRepository;
import com.example.userapi.service.PhoneService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@Transactional
@RequiredArgsConstructor
public class PhoneServiceImpl implements PhoneService {

    private final PhoneRepository phoneRepository;

    @Override
    @Transactional(readOnly = true)
    public Phone getPhoneById(Long id) {

        log.info("Find phone by id: {}", id);

        var phone = phoneRepository.findById(id).
            orElseThrow(() -> new NotFoundException("Can't find phone"));

        log.info("Phone with id {} successfully found", id);

        return phone;
    }

    @Override
    public Phone createPhone(String phone, User user) {

        log.info("Creating phone for user: {}", user);

        var phoneEntity = new Phone();

        phoneEntity.setPhone(phone);
        phoneEntity.setUser(user);

        var savedPhone = phoneRepository.save(phoneEntity);

        log.info("Phone with id {} successfully created", savedPhone.getId());

        return savedPhone;
    }
}
