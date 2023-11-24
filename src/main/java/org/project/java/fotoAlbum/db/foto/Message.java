package org.project.java.fotoAlbum.db.foto;

import org.hibernate.validator.constraints.Length;
import org.project.java.fotoAlbum.api.dto.MessageDto;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

@Entity
public class Message {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Email
    @NotBlank(message = "the email cannot be blank")
    private String email;

    @NotBlank(message = "the message cannot be blank")
    @Length(min = 3, message = "the message must be at least 3 chars")
    private String message;

    public Message() {}
    public Message(String email, String message) {
        setEmail(email);
        setMessage(message);
    }
    public Message(MessageDto message) {
        setEmail(message.getEmail());
        setMessage(message.getMessage());
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

    public void fillFromMessageDto(MessageDto message) {
        setEmail(message.getEmail());
        setMessage(message.getMessage());
    }

    @Override
    public int hashCode() {
        return getId();
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Message)) return false;
        Message incomingMessage = (Message)obj;
        return getId() == incomingMessage.getId();
    }

    @Override
    public String toString() {
        return "[" + getId() + "] Message:\n"
                + "email: " + getEmail() + "\n"
                + "message: " + getMessage();
    }

}