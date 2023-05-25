package com.example.userapi.mapper;

import com.example.userapi.entity.Account;
import com.example.userapi.model.AccountDto;
import com.example.userapi.model.PageAccountResponse;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.springframework.data.domain.Page;

@Mapper(uses = AccountMapper.class)
public interface AccountMapper {

    AccountMapper INSTANCE = Mappers.getMapper(AccountMapper.class);

    Account toAccount(AccountDto accountDto);

    AccountDto toAccountDTO(Account account);

    PageAccountResponse toPageAccountResponse(Page<AccountDto> page);
}
