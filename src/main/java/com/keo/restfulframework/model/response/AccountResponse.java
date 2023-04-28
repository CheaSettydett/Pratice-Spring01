package com.keo.restfulframework.model.response;

import com.keo.restfulframework.model.AccountType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AccountResponse {
    private int id;
    private String accountNo;
    private String accountName;
    private String profile;
    private String phoneNumber;
    private int tranferLimit;
    private AccountType accountType;
}
