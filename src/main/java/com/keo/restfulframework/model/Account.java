package com.keo.restfulframework.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Account {
    private int id;
    private String accountNo;
    private String accountName;
    private String profile;
    private int pin;
    private String passcode;
    private String phoneNumber;
    private int tranferLimit;
//    private int accountType;
    private AccountType accountType;
}
