package com.example.userapi.service.impl;

import com.example.userapi.entity.Email;
import com.example.userapi.entity.Phone;
import com.example.userapi.entity.User;
import com.example.userapi.mapper.EmailMapper;
import com.example.userapi.mapper.PhoneMapper;
import com.example.userapi.mapper.UserMapper;
import com.example.userapi.model.RegistrationUserDTO;
import com.example.userapi.model.UserCriteriaFilter;
import com.example.userapi.model.UserRequestDTOForUpdate;
import com.example.userapi.model.UserResponseDTO;
import com.example.userapi.repository.UserRepository;
import com.example.userapi.service.AccountService;
import com.example.userapi.service.EmailService;
import com.example.userapi.service.PhoneService;
import com.example.userapi.service.UserService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@Transactional
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final AccountService accountService;
    private final PhoneService phoneService;
    private final EmailService emailService;

    @Override
    public UserResponseDTO createUser(RegistrationUserDTO registrationUserDTO) {

        log.info("Creating user: {}", registrationUserDTO);

        var userEntity = UserMapper.INSTANCE.toUser(registrationUserDTO);

     //   setEmail_Phone(registrationUserDTO, userEntity);

        var savedUserEntity = userRepository.save(userEntity);

        setAccount(savedUserEntity);
       setEmail_Phone(registrationUserDTO, savedUserEntity);
        var savedUserEntityWithAccount = userRepository.save(savedUserEntity);
        //два save что с этим делать

        var userResponseDTO = UserMapper.INSTANCE
            .toUserResponseDTO(savedUserEntityWithAccount);

        log.info("Created user: {}", userResponseDTO);

        return userResponseDTO;
    }

    @Override
    public void deleteUserById(Long id) {

    }

    @Override
    public Page<UserResponseDTO> findByCriteria(UserCriteriaFilter filter) {
        return null;
    }

    @Override
    public List<UserResponseDTO> findAll() {
        return null;
    }

    @Override
    public UserResponseDTO findUserById(Long id) {
        return null;
    }

    @Override
    public UserResponseDTO updateUser(Long id, UserRequestDTOForUpdate userRequestDTOForUpdate) {
        return null;
    }

    private void setAccount(User user) {

        var account = accountService.createAccount(user);

        user.setAccount(account);
    }

    private void setEmail_Phone(RegistrationUserDTO registrationUserDTO, User user) {

        List<Email> emailList = EmailMapper.INSTANCE.toEmailList(registrationUserDTO.getEmail());
        List<Phone> phoneList = PhoneMapper.INSTANCE.toPhoneList(registrationUserDTO.getPhone());

        emailList.forEach(email -> {
            emailService.createEmail(
                email.getEmail(), user);
        });
        phoneList.forEach(phone -> {
            phoneService.createPhone(
                phone.getPhone(), user);
        });
////        user.getPhones().addAll(phoneList);
//        user.setEmails(emailList);
//        user.setPhones(phoneList);
    }
}
