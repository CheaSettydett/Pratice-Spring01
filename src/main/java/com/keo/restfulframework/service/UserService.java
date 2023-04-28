package com.keo.restfulframework.service;

import com.keo.restfulframework.model.User;
import com.keo.restfulframework.model.UserAccount;
import com.keo.restfulframework.model.request.UserRequest;

import java.util.List;

public interface UserService {
    List<User> getAllUser();
    List<User> findUserByName();
    User findByID(int id);

    int createNewUser(UserRequest user);
    int updateUser(UserRequest user ,int id);
    int removeUser(int id);

    List<UserAccount> getAllUserAccount();

}
