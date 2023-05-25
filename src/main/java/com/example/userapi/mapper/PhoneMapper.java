package com.example.userapi.mapper;

import com.example.userapi.entity.Phone;
import com.example.userapi.model.ShortPhoneDto;
import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(uses = PhoneMapper.class)
public interface PhoneMapper {

    PhoneMapper INSTANCE = Mappers.getMapper(PhoneMapper.class);

    List<Phone> toPhoneList(List<ShortPhoneDto> shortPhoneDtoList);

    List<ShortPhoneDto> toShortPhoneDTOList(List<Phone> phoneList);
}
