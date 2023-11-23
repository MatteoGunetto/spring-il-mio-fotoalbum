package org.project.java.fotoAlbum.db.foto;

import java.util.Arrays;
import java.util.List;

import org.hibernate.validator.constraints.Length;
import org.project.java.fotoAlbum.api.dto.PhotoDto;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.validation.constraints.NotBlank;

@Entity
public class Photo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(length = 128, nullable = false)
    @NotBlank(message = "the title cannot be blank")
    @Length(min = 3, message = "the title must is at least 3 chars long")
    private String title;

    @NotBlank(message="the description cannot be blank")
    @Length(min = 3, max = 255, message="the description must be at least 3 characters and less of 255")
    private String description;

    @NotBlank(message = "the url cannot be blank")
    private String url;

    private boolean visible;

    @ManyToMany
    @JsonManagedReference
    private List<Category> categories;

    public Photo() {}
    public Photo(String title, String description, String url, boolean visible, Category... categories) {
        setTitle(title);
        setDescription(description);
        setUrl(url);
        setVisible(visible);
        setCategories(Arrays.asList(categories));
    }
    public Photo(PhotoDto photo) {
        setTitle(photo.getTitle());
        setDescription(photo.getDescription());
        setUrl(photo.getUrl());
        setVisible(photo.isVisible());
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public String getUrl() {
        return url;
    }
    public void setUrl(String url) {
        this.url = url;
    }
    public boolean isVisible() {
        return visible;
    }
    public void setVisible(boolean visible) {
        this.visible = visible;
    }
    public List<Category> getCategories() {
        return categories;
    }
    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }

    @Override
    public int hashCode() {
        return getId();
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Photo)) return false;
        Photo incomingPhoto = (Photo)obj;
        return getId() == incomingPhoto.getId();
    }

    public void addCategories(Category... categories) {
        getCategories().addAll(Arrays.asList(categories));
    }

    public boolean hasCategory(Category category) {
        if(getCategories() == null) return false;

        for(Category tempCategory : getCategories()) {
            if(tempCategory.getId() == category.getId()) return true;
        }

        return false;
    }

    public void removeCategories(Category... categories) {
        getCategories().removeAll(Arrays.asList(categories));
    }

    public void fillFromPhotoDto(PhotoDto photoDto) {
        setTitle(photoDto.getTitle());
        setDescription(photoDto.getDescription());
        setUrl(photoDto.getUrl());
        setVisible(photoDto.isVisible());
    }

    @Override
    public String toString() {
        return "[" + getId() + "] Photo:\n"
                + "title: " + getTitle() + "\n"
                + "description: " + getDescription() + "\n"
                + "url: " + getUrl() + "\n"
                + "visibility: " + isVisible();
    }
}