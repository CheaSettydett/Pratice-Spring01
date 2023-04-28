package com.keo.restfulframework.service.serviceimpl;

import com.keo.restfulframework.model.User;
import com.keo.restfulframework.model.UserAccount;
import com.keo.restfulframework.model.request.UserRequest;
import com.keo.restfulframework.repository.UserRepository;
import com.keo.restfulframework.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    UserRepository userRepository;

    UserServiceImpl(UserRepository userRepository){
        this.userRepository = userRepository;
    }


    @Override
    public List<User> getAllUser() {
        return userRepository.getAllUser();
    }

    @Override
    public List<User> findUserByName() {
        return null;
    }


    @Override
    public User findByID(int id) {
        return userRepository.findUserById(id);
    }

    @Override
    public int createNewUser(UserRequest user) {
        return userRepository.createNewuser(user);
    }

    @Override
    public int updateUser(UserRequest user, int id) {
        return userRepository.updateUser(user, id);
    }

    @Override
    public int removeUser(int id) {
        return userRepository.removeUser(id);
    }

    @Override
    public List<UserAccount> getAllUserAccount() {
        return userRepository.getAllUserAccount();
    }
}
