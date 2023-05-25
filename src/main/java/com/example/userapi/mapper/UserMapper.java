package com.example.userapi.mapper;

import com.example.userapi.entity.Email;
import com.example.userapi.entity.Phone;
import com.example.userapi.entity.User;
import com.example.userapi.model.PageUserResponse;
import com.example.userapi.model.RegistrationUserDTO;
import com.example.userapi.model.ShortEmailDto;
import com.example.userapi.model.ShortPhoneDto;
import com.example.userapi.model.UserRequestDTOForUpdate;
import com.example.userapi.model.UserResponseDTO;
import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.springframework.data.domain.Page;

@Mapper(uses = UserMapper.class)
public interface UserMapper {

    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    User toUser(RegistrationUserDTO registrationUserDTO);

    User toUserForUpdate(UserRequestDTOForUpdate userRequestDTOForUpdate);

    UserResponseDTO toUserResponseDTO(User user);

    PageUserResponse toPageUserResponse(Page<UserResponseDTO> page);

    List<Phone> toPhoneList(List<ShortPhoneDto> shortPhoneDtoList);

    List<ShortPhoneDto> toShortPhoneDTOList(List<Phone> phoneList);

    List<Email> toEmailList(List<ShortEmailDto> shortEmailDtoList);

    List<ShortEmailDto> toShortEmailDTOList(List<Email> emailList);
}
