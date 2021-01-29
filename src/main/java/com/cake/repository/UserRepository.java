package com.cake.repository;

import com.cake.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {

  UserEntity findByProviderIdAndProviderUserId(String providerId, String providerUserId);

  Optional<UserEntity> findByEmail(String email);

  Optional<UserEntity> findByUsername(String username);


}
