package com.keo.restfulframework.service;

import com.keo.restfulframework.model.Account;

import java.util.List;

public interface AccountService {
    List<Account> getAllAccount();
    int createAccount(Account account);
    int updateAccount(Account account ,int id);
    Account findAccountByID(int id);
}
