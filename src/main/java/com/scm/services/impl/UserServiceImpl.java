package com.scm.services.impl;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.hibernate.validator.internal.util.logging.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.scm.entities.User;
import com.scm.helpers.ResourceNotFoundException;
import com.scm.repositories.UserRepo;
import com.scm.services.UserService;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepo userRepo;

    // private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public User saveUser(User user) {
        // user:id have to generate
        String userId = UUID.randomUUID().toString();
        user.setUserId(userId);
        // password encode
        user.setPassword(userId);

        return userRepo.save(user);
    }

    @Override
    public Optional<User> getUserById(String id) {
        return userRepo.findById(id);
    }

    @Override
    public Optional<User> updateUser(User user) {
        User u2 = userRepo.findById(user.getUserId())
                .orElseThrow(() -> new ResourceNotFoundException("user not found"));
        u2.setName(user.getName());
        u2.setEmail(user.getEmail());
        u2.setPassword(user.getPassword());
        u2.setAbout(user.getAbout());
        u2.setPhoneNumber(user.getPhoneNumber());
        u2.setProfilePic(user.getProfilePic());
        u2.setEnabled(user.isEnabled());
        u2.setEmailVerified(user.isEmailVerified());
        u2.setPhoneVerified(user.isPhoneVerified());
        u2.setProvider(user.getProvider());
        u2.setProvideUserId(user.getProvideUserId());

        // save the user in db
        User save = userRepo.save(u2);
        return Optional.ofNullable(save);
    }

    @Override
    public void deleteUser(String id) {
        User u2 = userRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("user not found"));

        userRepo.delete(u2);
    }

    @Override
    public boolean isUserExist(String userId) {
        User u2 = userRepo.findById(userId).orElse(null);
        return u2 != null ? true : false;
    }

    @Override
    public boolean isUserExistsByEmail(String email) {
        User user2 = userRepo.findByEmail(email).orElse(null);
        return user2 != null ? true : false;
    }

    @Override
    public List<User> getAllUsers() {
        return userRepo.findAll();
    }

}
