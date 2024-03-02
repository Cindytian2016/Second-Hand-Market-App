package com.laioffer.secondhandmarket.model;


import jakarta.persistence.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;


import java.util.Collection;
import java.util.List;
import java.util.Objects;

/*
@Entity // hibernate
@Table(name = "users")
public class UserEntity implements UserDetails {
    @Id // primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long user_id;
    private String username;
    private String password;
    @Enumerated(EnumType.STRING)
    private UserRole role;


    public UserEntity() {
    }


    public UserEntity(Long user_id, String username, String password, UserRole role) {
        this.user_id = user_id;
        this.username = username;
        this.password = password;
        this.role = role;
    }


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority(role.name()));
    }


    @Override
    public String getPassword() {
        return password;
    }


    @Override
    public String getUsername() {
        return username;
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


    public Long getId() {
        return user_id;
    }


    public UserRole getRole() {
        return role;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserEntity that = (UserEntity) o;
        return Objects.equals(user_id, that.user_id) && Objects.equals(username, that.username) && Objects.equals(password, that.password) && role == that.role;
    }


    @Override
    public int hashCode() {
        return Objects.hash(user_id, username, password, role);
    }


    @Override
    public String toString() {
        return "UserEntity{" +
                "id=" + user_id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", role=" + role +
                '}';
    }
}
*/


@Entity // Hibernate annotation
@Table(name = "users") // Table name
public class UserEntity implements UserDetails {
    @Id // Primary key annotation
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Auto-increment
    private Long user_id;
    private String username;
    private String password;
    private String email; // Add the email field
    @Enumerated(EnumType.STRING)
    private UserRole role;

    public UserEntity() {
    }

    // Modify the constructor to include the email parameter
    public UserEntity(Long user_id, String username, String password, String email, UserRole role) {
        this.user_id = user_id;
        this.username = username;
        this.password = password;
        this.email = email; // Assign the email parameter to the email field
        this.role = role;
    }

    public UserEntity(Object o, String username, String encode, UserRole role) {
    }

    // Getters and Setters
    public Long getId() {
        return user_id;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() { // Getter for email
        return email;
    }

    public void setEmail(String email) { // Setter for email
        this.email = email;
    }

    public UserRole getRole() {
        return role;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority(role.name()));
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

    // Update equals, hashCode, and toString to include email
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserEntity that = (UserEntity) o;
        return Objects.equals(user_id, that.user_id) && Objects.equals(username, that.username) && Objects.equals(password, that.password) && Objects.equals(email, that.email) && role == that.role;
    }

    @Override
    public int hashCode() {
        return Objects.hash(user_id, username, password, email, role);
    }

    @Override
    public String toString() {
        return "UserEntity{" +
                "id=" + user_id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", role=" + role +
                '}';
    }
}