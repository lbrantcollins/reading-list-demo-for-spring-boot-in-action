package com.collins.readinglist.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Collection;

import static java.util.Collections.singletonList;

@Entity
@Getter
@Setter
public class Reader implements UserDetails {

    private static final long serialVersionUID = 1L;

    @Id
    private String username;
    private String fullName;
    private String password;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return singletonList(new SimpleGrantedAuthority("READER"));
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
}
