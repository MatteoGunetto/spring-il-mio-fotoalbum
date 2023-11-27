package org.project.java.fotoAlbum.api.dto;

// Definizione di un Data Transfer Object (DTO) per rappresentare un messaggio
public class MessageDto {

    // Variabile di istanza per l'identificatore unico del messaggio
    private int id;

    // Variabile di istanza per l'indirizzo email associato al messaggio
    private String email;

    // Variabile di istanza per il contenuto del messaggio
    private String message;

    // Costruttore vuoto del DTO
    public MessageDto() {}

    // Costruttore con parametri per agevolare la creazione del DTO con dati iniziali
    public MessageDto(String email, String message) {
        setEmail(email);
        setMessage(message);
    }

    // Metodo getter per ottenere l'identificatore del messaggio
    public int getId() {
        return id;
    }

    // Metodo setter per impostare l'identificatore del messaggio
    public void setId(int id) {
        this.id = id;
    }

    // Metodo getter per ottenere l'indirizzo email associato al messaggio
    public String getEmail() {
        return email;
    }

    // Metodo setter per impostare l'indirizzo email associato al messaggio
    public void setEmail(String email) {
        this.email = email;
    }

    // Metodo getter per ottenere il contenuto del messaggio
    public String getMessage() {
        return message;
    }

    // Metodo setter per impostare il contenuto del messaggio
    public void setMessage(String message) {
        this.message = message;
    }

    // Override del metodo toString() per ottenere una rappresentazione di stringa formattata del DTO
    @Override
    public String toString() {
        return "[" + getId() + "] Message:\n"
                + "email: " + getEmail() + "\n"
                + "message: " + getMessage();
    }
}
