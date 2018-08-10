package com.notify.NotifyEgerton.model;

import java.util.Collection;
import java.util.List;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.util.StringUtils;

public class CustomeUserDetails extends User implements UserDetails {


    private static final long serialVersionUID = 1L;
    private List<String> userRole;

    public CustomeUserDetails(User user, List<String> userRole ) {
        super(user);
        this.userRole = userRole;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {

        String roles = StringUtils.collectionToCommaDelimitedString(userRole);
        return AuthorityUtils.commaSeparatedStringToAuthorityList(roles);
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

    @Override
    public String getUsername(){
        return super.getUsername();
    }
}


