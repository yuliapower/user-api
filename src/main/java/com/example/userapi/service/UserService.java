package com.example.userapi.service;

import com.example.userapi.model.RegistrationUserDTO;
import com.example.userapi.model.UserCriteriaFilter;
import com.example.userapi.model.UserRequestDTOForUpdate;
import com.example.userapi.model.UserResponseDTO;
import java.util.List;
import org.springframework.data.domain.Page;

public interface UserService {

    UserResponseDTO createUser(RegistrationUserDTO registrationUserDTO);

    void deleteUserById(Long id);

    Page<UserResponseDTO> findByCriteria(UserCriteriaFilter filter);

    List<UserResponseDTO> findAll();

    UserResponseDTO findUserById(Long id);

    UserResponseDTO updateUser(Long id, UserRequestDTOForUpdate userRequestDTOForUpdate);

}
