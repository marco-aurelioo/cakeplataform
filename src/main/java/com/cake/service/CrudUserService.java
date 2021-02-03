package com.cake.service;

import com.cake.dto.Permissao;
import com.cake.dto.UserProfile;
import com.cake.entity.PermissaoEntity;
import com.cake.entity.UserEntity;
import com.cake.repository.PermissionRepository;
import com.cake.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CrudUserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PermissionRepository permissionRepository;

    public boolean criarUsuario(UserProfile user){
        final Optional<UserEntity> optionalUser = userRepository.findByEmail(user.getEmail());
        if (!optionalUser.isPresent()) {
            UserEntity entity = new UserEntity();
            List<String> grants = user.getAuthorities().stream().map(GrantedAuthority::getAuthority).collect(Collectors.toList());
            entity.setGrants(getGrants(grants));
            entity.setPassword(user.getPassword());
            entity.setEmail(user.getEmail());
            entity.setUsername(user.getUsername());
            userRepository.save(entity);
           return true;
        } else {
            return false;
        }
    }

    private List<PermissaoEntity> getGrants(List<String> grants) {
        List<PermissaoEntity> lista =new ArrayList<>();
        Iterable<PermissaoEntity> permissions = permissionRepository.findAll();
        for(PermissaoEntity p: permissions){
            for(String grant: grants ){
                if(p.getPermissao().equals(grant)){
                    lista.add(p);
                }
            }
        }
        return lista;
    }

    public UserProfile getUserProfile(String email){
        final Optional<UserEntity> entity = userRepository.findByEmail(email);
        return getUserProfile(entity);
    }

    public UserProfile findByProviderIdAndProviderUserId(String principalValue, String principalValue1) {
        final Optional<UserEntity> entity = userRepository
                .findByProviderIdAndProviderUserId(principalValue, principalValue1);
        return getUserProfile(entity);
    }

    private UserProfile getUserProfile(Optional<UserEntity> optionalUser) {
        if (optionalUser.isPresent()) {
            UserEntity entity = optionalUser.get();
            UserProfile user = new UserProfile();
            user.setIdentity(entity.getId().toString());
            List<String> grantsStr = entity.getGrants().stream().map(PermissaoEntity::getPermissao ).collect(Collectors.toList());
            List<GrantedAuthority> grants = new ArrayList();
            for(String s: grantsStr){
                grants.add(new Permissao(s));
            }
            user.setAuthorities(grants);
            user.setPassword(entity.getPassword());
            user.setEmail(entity.getEmail());
            user.setName(entity.getUsername());
            return user;
        }
        else {
            throw new UsernameNotFoundException("User cannot be found.");
        }
    }



}
