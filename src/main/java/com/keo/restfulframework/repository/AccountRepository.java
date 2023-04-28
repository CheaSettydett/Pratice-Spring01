package com.keo.restfulframework.repository;

import com.keo.restfulframework.model.AccountType;
import com.keo.restfulframework.model.Account;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;


@Mapper
@Repository
public interface AccountRepository {
    @Results({
            @Result(property = "accountNo", column = "account_no"),
            @Result(property = "accountName" , column = "account_name"),
            @Result(property = "passcode" , column = "password"),
            @Result(property = "phoneNumber", column = "phone_number"),
            @Result(property = "tranferLimit", column = "tranfer_limit"),
            @Result(column = "account_type" ,property = "accountType",one = @One(select = "getAccountTypeByID"))
    })
    @Select("Select * from account_tb")
    List<Account> getAllAccount();
    int createAccount(Account account);


    @Result(property = "accountType" , column = "name")
    @Select("select * from accounttypes_tb where id =#{account_type}")
    AccountType getAccountTypeByID(int account_type);


    int updateAccount(Account account,int id);
    Account findAccountByID(int id);
}

