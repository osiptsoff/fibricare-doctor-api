package ru.spb.fibricare.api.doctorapi.security.model;

import org.springframework.security.core.GrantedAuthority;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class GrantedAuthorityImpl implements GrantedAuthority {
    private String name;

    @Override
    public String getAuthority() {
        return name;
    }
    
}
