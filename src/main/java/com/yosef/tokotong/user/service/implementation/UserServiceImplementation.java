package com.yosef.tokotong.user.service.implementation;

import com.yosef.tokotong.exceptions.applicationException.ApplicationException;
import com.yosef.tokotong.exceptions.notFoundException.NotFoundException;
import com.yosef.tokotong.response.Response;
import com.yosef.tokotong.user.entity.User;
import com.yosef.tokotong.user.repository.UserRepository;
import com.yosef.tokotong.user.service.UserService;
import lombok.extern.java.Log;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Log
public class UserServiceImplementation implements UserService {
  private final UserRepository userRepository;

  public UserServiceImplementation (UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  @Override
  public List<User> getAllUsers() {
    var result = userRepository.findAll();
    if (result.isEmpty()){
     throw new NotFoundException("Users is empty");
    }
    return result;
  }

  @Override
  public User createUser(User user) {
    var result = userRepository.findByName(user.getName());
    if (!result.isEmpty()) {
      throw new ApplicationException("Username already exists");
    }
    return userRepository.save(user);
  }
}
