package com.keo.restfulframework.service.serviceimpl;

import com.keo.restfulframework.model.Account;
import com.keo.restfulframework.repository.AccountRepository;
import com.keo.restfulframework.service.AccountService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountServiceImpl implements AccountService {
    public final AccountRepository accountRepository;
    AccountServiceImpl(AccountRepository accountRepository){
        this.accountRepository = accountRepository;
    }

    @Override
    public List<Account> getAllAccount() {
        return accountRepository.getAllAccount();
    }

    @Override
    public int createAccount(Account account) {
        return 0;
    }

    @Override
    public int updateAccount(Account account, int id) {
        return 0;
    }

    @Override
    public Account findAccountByID(int id) {
        return accountRepository.findAccountByID(id);
    }
}