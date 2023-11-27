package org.project.java.fotoAlbum.api.dto;

// Definizione di un Data Transfer Object (DTO) per rappresentare una foto
public class PhotoDto {

    // Variabile di istanza per l'identificatore unico della foto
    private int id;

    // Variabile di istanza per il titolo della foto
    private String title;

    // Variabile di istanza per la descrizione della foto
    private String description;

    // Variabile di istanza per l'URL della foto
    private String url;

    // Variabile di istanza per indicare se la foto è visibile o meno
    private boolean visible;

    // Costruttore vuoto del DTO
    public PhotoDto() {}

    // Costruttore con un parametro per agevolare la creazione del DTO con un titolo iniziale
    public PhotoDto(String title) {
        setTitle(title);
    }

    // Metodo getter per ottenere l'identificatore della foto
    public int getId() {
        return id;
    }

    // Metodo setter per impostare l'identificatore della foto
    public void setId(int id) {
        this.id = id;
    }

    // Metodo getter per ottenere il titolo della foto
    public String getTitle() {
        return title;
    }

    // Metodo setter per impostare il titolo della foto
    public void setTitle(String title) {
        this.title = title;
    }

    // Metodo getter per ottenere la descrizione della foto
    public String getDescription() {
        return description;
    }

    // Metodo setter per impostare la descrizione della foto
    public void setDescription(String description) {
        this.description = description;
    }

    // Metodo getter per ottenere l'URL della foto
    public String getUrl() {
        return url;
    }

    // Metodo setter per impostare l'URL della foto
    public void setUrl(String url) {
        this.url = url;
    }

    // Metodo getter per ottenere la visibilità della foto
    public boolean isVisible() {
        return visible;
    }

    // Metodo setter per impostare la visibilità della foto
    public void setVisible(boolean visible) {
        this.visible = visible;
    }

    // Override del metodo toString() per ottenere una rappresentazione di stringa formattata del DTO
    @Override
    public String toString() {
        return "[" + getId() + "] Photo:\n"
                + "title: " + getTitle() + "\n"
                + "description: " + getDescription() + "\n"
                + "url: " + getUrl() + "\n"
                + "visibility: " + isVisible();
    }
}
