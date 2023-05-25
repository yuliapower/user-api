package com.example.userapi.controller;

import com.example.userapi.service.UserService;
import com.example.userapi.mapper.UserMapper;
import com.example.userapi.model.PageUserResponse;
import com.example.userapi.model.RegistrationUserDTO;
import com.example.userapi.model.UserCriteriaFilter;
import com.example.userapi.model.UserRequestDTOForUpdate;
import com.example.userapi.model.UserResponseDTO;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
public class UserController implements UserApi {

    private final UserService userService;

    @Override
    public ResponseEntity<UserResponseDTO> addUser(RegistrationUserDTO registrationUserDTO) {

        log.info("Creating user: " + registrationUserDTO);

        return ResponseEntity
            .status(HttpStatus.CREATED)
            .body(userService.createUser(registrationUserDTO));
    }

    @Override
    public ResponseEntity<Void> deleteUserById(Long id) {

        log.info("Delete user with id: {}",id);

        userService.deleteUserById(id);

        return null;
    }

    @Override
    public ResponseEntity<PageUserResponse> finaAllUsersByCriteria(UserCriteriaFilter filter) {

        log.info("Find all users by filter: {}", filter);

        var response = userService.findByCriteria(filter);

        return ResponseEntity.ok(UserMapper.INSTANCE.toPageUserResponse(response));
    }

    @Override
    public ResponseEntity<List<UserResponseDTO>> findAll() {

        log.info("Find all users");

        return ResponseEntity.ok(userService.findAll());
    }

    @Override
    public ResponseEntity<UserResponseDTO> findUserById(Long id) {

        log.info("Find user by id: " + id);

        return ResponseEntity.ok(userService.findUserById(id));
    }

    @Override
    public ResponseEntity<UserResponseDTO> updateUserById(Long id,
        UserRequestDTOForUpdate userRequestDTOForUpdate) {

        log.info("Change user: " + userRequestDTOForUpdate);

        return ResponseEntity.ok(userService.updateUser(id, userRequestDTOForUpdate));
    }
}
