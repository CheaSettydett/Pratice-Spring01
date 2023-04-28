package com.keo.restfulframework.mapper;

import com.keo.restfulframework.model.Account;
import com.keo.restfulframework.model.response.AccountResponse;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")

public interface AutoAccountMapper {
    //account -> accountresponse
    List<AccountResponse> mapToAccountResponse(List<Account> accounts);

    //account-response ->account
    List<Account> mapToAccount(List<AccountResponse> responses);
}
