package com.cake.service;

import com.cake.dto.UserProfile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService implements UserDetailsService {

    @Autowired
    private CrudUserService userService;

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        UserProfile userProfile = userService.getUserProfile(email);
        BCryptPasswordEncoder encoder = passwordEncoder();
        return new org.springframework.security.core.userdetails.User(
                userProfile.getUsername()
                ,encoder.encode(userProfile.getPassword()),userProfile.getAuthorities());
    }


    public void updateUser(UserProfile update) {
        System.out.println("ok"+update.getIdentity());
        UserProfile principal =( UserProfile ) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        System.out.println("ok"+principal.getIdentity());

    }
}
