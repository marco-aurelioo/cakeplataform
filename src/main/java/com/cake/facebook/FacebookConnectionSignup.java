package com.cake.facebook;

import com.cake.entity.PermissaoEntity;
import com.cake.entity.UserEntity;
import com.cake.repository.PermissionRepository;
import com.cake.repository.UserRepository;

import java.util.Arrays;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.social.connect.Connection;
import org.springframework.social.connect.ConnectionSignUp;
import org.springframework.stereotype.Service;

@Service
public class FacebookConnectionSignup implements ConnectionSignUp {

  @Autowired
  private UserRepository userRepository;

  @Autowired
  private PermissionRepository permissionRepository;

  @Override
  public String execute(Connection<?> connection) {
    UserEntity user = new UserEntity();

    user.setPassword(UUID.randomUUID().toString());

    user.setUsername(connection.getDisplayName());
    user.setImgUrl(connection.getImageUrl());
    user.setProviderId(connection.getKey().getProviderId());
    user.setProviderUserId(connection.getKey().getProviderUserId());

    Iterable<PermissaoEntity> permissions
            = permissionRepository.findAll();

    for(PermissaoEntity p: permissions){
      if(p.getPermissao().equals("SITE") || p.getPermissao().equals("USER")) {
        user.getGrants().add(p);
      }
    }

    userRepository.save(user);
    return user.getUsername();
  }
}