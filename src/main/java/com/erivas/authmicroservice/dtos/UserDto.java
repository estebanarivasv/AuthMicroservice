package com.erivas.authmicroservice.dtos;

import javax.validation.constraints.NotNull;

public class UserDto {

    private String username;
    private @NotNull String email;
    private @NotNull String password;
    private Boolean deleted;
    private Boolean activated;

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
