package com.yosef.tokotong.user.service;

import com.yosef.tokotong.user.entity.User;

import java.util.List;

public interface UserService {
  public List<User> getAllUsers();

  public User createUser(User user);
}
