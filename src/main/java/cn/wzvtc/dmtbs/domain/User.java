package cn.wzvtc.dmtbs.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import java.util.ArrayList;
import java.util.Collection;
import java.util.UUID;

@Data
@Entity
@EqualsAndHashCode(of = "id")
public class User implements UserDetails {

    @Id
    private String id;

    private String username;

    private String password;


    @PrePersist
    public void perPersist() {
        id = UUID.randomUUID().toString();
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return new ArrayList<>(0);
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
    public String getUsername() {
        return username;
    }

    @Override
    public String getPassword() {
        return password;
    }
}
