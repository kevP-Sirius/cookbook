package com.cookbook.app.Service.User;

import com.cookbook.app.Entity.Recipe;
import com.cookbook.app.Entity.User;
import com.cookbook.app.Repository.UserRepository;

import java.util.List;

public class UserService implements IUserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> findAll(){
        return userRepository.findAll();
    }

    public User createUser(User user){
        return userRepository.save(user);
    }

    public boolean deleteUser(User user){
        userRepository.delete(user);
        return true;
    }
}
