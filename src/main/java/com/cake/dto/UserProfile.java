package com.cake.dto;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class UserProfile implements UserDetails {

  private String name;
  private String password;
  private String email;
  private String imgProfile;

  List<GrantedAuthority> authorities = new ArrayList<>();

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  @Override
  public Collection<? extends GrantedAuthority> getAuthorities() {
    return authorities;
  }

  public void setAuthorities(List<String> grants) {
    for(String grant: grants){
      authorities.add(new Permissao(grant));
    }
  }


  public String getPassword() {
    return password;
  }

  @Override
  public String getUsername() {
    return this.name;
  }

  @Override
  public boolean isAccountNonExpired() {
    return true;
  }

  @Override
  public boolean isAccountNonLocked() {
    return true;
  }

  @Override
  public boolean isCredentialsNonExpired() {
    return true;
  }

  @Override
  public boolean isEnabled() {
    return true;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getImgProfile() {
    return imgProfile;
  }

  public void setImgProfile(String imgProfile) {
    this.imgProfile = imgProfile;
  }
}
