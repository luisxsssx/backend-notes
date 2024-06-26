package com.api.notes.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@Entity
@Table(name = "USER_DATA", uniqueConstraints = {@UniqueConstraint(columnNames = {"username"})})
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserModel implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long UUID;

    @Column(unique = true)
    private String username;

    @Column(length = 50)
    private String first_name;

    @Column(length = 50)
    private String last_name;

    @Column(length = 100, unique = true)
    private String email;

    @Enumerated(EnumType.STRING)
    private Role role;

    @Column(length = 15, unique = true)
    private String password;

    @OneToMany(mappedBy = "user")
    @JsonIgnore
    private List<NotesModel> notes;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority((role.name())));
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