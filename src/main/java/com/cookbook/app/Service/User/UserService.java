package com.cookbook.app.Service.User;

import com.cookbook.app.Entity.Recipe;
import com.cookbook.app.Repository.UserRepository;

public class UserService implements IUserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
}
