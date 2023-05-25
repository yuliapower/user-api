package com.example.userapi.mapper;

import com.example.userapi.entity.Email;
import com.example.userapi.model.ShortEmailDto;
import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(uses = EmailMapper.class)
public interface EmailMapper {

    EmailMapper INSTANCE = Mappers.getMapper(EmailMapper.class);

    //Email toEmail(ShortEmailDto shortEmailDto);

    List<Email> toEmailList(List<ShortEmailDto> shortEmailDtoList);

    List<ShortEmailDto> toShortEmailDTOList(List<Email> emailList);
}
