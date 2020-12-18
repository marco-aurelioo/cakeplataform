package com.cake.facebook;

import com.cake.entity.UserEntity;
import com.cake.repository.UserRepository;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.social.connect.Connection;
import org.springframework.social.connect.ConnectionSignUp;
import org.springframework.stereotype.Service;

@Service
public class FacebookConnectionSignup implements ConnectionSignUp {

  @Autowired
  private UserRepository userRepository;

  @Override
  public String execute(Connection<?> connection) {
    UserEntity user = new UserEntity();
    user.setUsername(connection.getDisplayName());
    user.setPassword(UUID.randomUUID().toString());
    userRepository.save(user);
    return user.getUsername();
  }
}