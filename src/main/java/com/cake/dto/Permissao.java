package com.cake.dto;

import org.springframework.security.core.GrantedAuthority;

public class Permissao implements GrantedAuthority {

    private String grant;

    public Permissao(String grant){
        this.grant = grant;
    }

    @Override
    public String getAuthority() {
        return grant;
    }
}
