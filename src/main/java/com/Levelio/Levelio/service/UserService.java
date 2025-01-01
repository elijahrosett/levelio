package com.Levelio.Levelio.service;

import com.Levelio.Levelio.dao.UserDao;
import com.Levelio.Levelio.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserDao userDao;

    public User createUser(User user) {
        return userDao.save(user);
    }

    public User getByUserId(int id) {
        return userDao.findById(id).orElseThrow(() -> new RuntimeException("User not found by Id"));
    }

    public User getByUsername(String username) {
        return userDao.findByUsername(username);
    }

    public User getByEmail(String email) {
        return userDao.findByEmail(email);
    }

    public void deleteUserById(int id) {
        userDao.deleteById(id);
    }

}
