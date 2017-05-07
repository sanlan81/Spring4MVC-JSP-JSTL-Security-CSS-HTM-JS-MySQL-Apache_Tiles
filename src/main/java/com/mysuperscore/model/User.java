package com.mysuperscore.model;

import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

public class User implements Serializable {

    private int Id;

    @Size(min = 5, max = 10)
    @NotNull
    private String username;
    @NotEmpty
    @Size(min = 5, max = 10)
    private String password;
    @NotEmpty
    private String passwordConfirm;
    private int tinyint;

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPasswordConfirm() {
        return passwordConfirm;
    }

    public void setPasswordConfirm(String passwordConfirm) {
        this.passwordConfirm = passwordConfirm;
    }

    public int getTinyint() {
        return tinyint;
    }

    public void setTinyint(int tinyint) {
        this.tinyint = tinyint;
    }
}
