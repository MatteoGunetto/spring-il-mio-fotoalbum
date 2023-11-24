package org.project.java.fotoAlbum.api.dto;

public class MessageDto {
    private int id;
    private String email;
    private String message;

    public MessageDto() {}
    public MessageDto(String email, String message) {
        setEmail(email);
        setMessage(message);
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "[" + getId() + "] Message:\n"
                + "email: " + getEmail() + "\n"
                + "message: " + getMessage();
    }
}