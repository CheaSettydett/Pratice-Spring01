package com.keo.restfulframework.repository;

import com.keo.restfulframework.model.Account;
import com.keo.restfulframework.model.User;
import com.keo.restfulframework.model.UserAccount;
import com.keo.restfulframework.model.request.UserRequest;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface UserRepository {

    @Select("SELECT * FROM users_tb")
    @Result(column = "id" ,property = "userID")
    List<User> getAllUser();

    List<User> findUserByUsername(String username);

    @Select("insert into  users_tb (name,gender,address)\n" +
            "values (#{user.name},#{user.gender},#{user.address}) returning id;")
    int createNewuser(@Param("user") UserRequest user);

    @Update("update users_tb\n" +
            "        set name = #{user.name},\n" +
            "            gender = #{user.gender},\n" +
            "            address = #{user.address}\n" +
            "where id = #{id};")
    int updateUser(@Param("user") UserRequest user, int id);

    @Delete("delete from users_tb where id = #{id};")
    int removeUser(int id);

    @Select("select * from users_tb where id = #{id}")
    @Result(column = "id" ,property = "userID")
    User findUserById(int id);



    @Results({
            @Result(column = "id", property = "userID"),
            @Result(column = "id",property = "accounts" , many= @Many(select = "findAccountByUserId"))
    })

    @Select("SELECT * FROM users_tb")
    List<UserAccount> getAllUserAccount();


    @Results({
            @Result(property = "accountNo", column = "account_no"),
            @Result(property = "accountName" , column = "account_name"),
            @Result(property = "passcode" , column = "password"),
            @Result(property = "phoneNumber", column = "phone_number"),
            @Result(property = "tranferLimit", column = "tranfer_limit"),
            @Result(property = "accountType" ,column = "account_type",one = @One(select = "com.keo.restfulframework.repository.AccountRepository.getAccountTypeByID"))
    })
    @Select("select * from user_account_tb inner join account_tb a on a.id = user_account_tb.account_id\n" +
            "where user_id = #{id}")

    List<Account>findAccountByUserId(int id);

}
