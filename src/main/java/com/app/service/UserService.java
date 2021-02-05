package com.app.service;


import com.app.entity.User;

public interface UserService {

    User findOrCreateUser(String name,
                          String surname,
                          String phone,
                          String email,
                          String address);


}
