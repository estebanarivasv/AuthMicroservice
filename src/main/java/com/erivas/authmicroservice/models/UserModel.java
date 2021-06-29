package com.erivas.authmicroservice.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Objects;

// Defines this class ready to be stored as an object in JPA
@Entity
@Table(name = "users")
public class UserModel implements Serializable {
    private @Id @GeneratedValue Long id;
    private @NotNull String username;
    private @NotNull String email;
    private @NotNull String password;
    private Boolean deleted;
    private Boolean activated;

    // Hibernate requires a no-arg constructor
    public UserModel() {}

    public UserModel(String username, String email, String password,
                     Boolean deleted, Boolean activated) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.deleted = deleted;
        this.activated = activated;
    }

    public Long getId() {
        return id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public void setDeleted(Boolean deleted) {
        this.deleted = deleted;
    }

    public Boolean getDeleted() {
        return deleted;
    }

    public void setActivated(Boolean activated) {
        this.activated = activated;
    }

    public Boolean getActivated() {
        return activated;
    }
}
