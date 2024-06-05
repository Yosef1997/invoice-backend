package com.yosef.tokotong.user;

import com.yosef.tokotong.response.Response;
import com.yosef.tokotong.user.entity.User;
import com.yosef.tokotong.user.service.UserService;
import jakarta.validation.Valid;
import lombok.extern.java.Log;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/user")
@Log
public class UserController {
  private final UserService userService;

  public UserController(UserService userService) {
    this.userService = userService;
  }

  @GetMapping("/")
  public ResponseEntity<Response<List<User>>> getUsers() {
    return Response.successResponse("All users fetched", userService.getAllUsers());
  }

  @PostMapping("/")
  public ResponseEntity<Response<User>> createUser( @RequestBody User user) {
    return Response.successResponse("Create user success", userService.createUser(user));
  }
}
