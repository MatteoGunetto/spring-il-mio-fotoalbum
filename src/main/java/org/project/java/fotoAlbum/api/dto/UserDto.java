package org.project.java.fotoAlbum.api.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public class UserDto {
    @NotNull
    @NotEmpty
    private String username;

    @NotNull
    @NotEmpty
    private String password;

    public UserDto() {}
    public UserDto(String username, String password) {
        setUsername(username);
        setPassword(password);
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


}