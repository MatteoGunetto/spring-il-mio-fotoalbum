package org.project.java.fotoAlbum.db.foto;

import java.util.Arrays;
import java.util.List;
import org.hibernate.validator.constraints.Length;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.validation.constraints.NotBlank;

@Entity
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(length = 128, nullable=false)
    @NotBlank(message="the name cannot be blank")
    @Length(min = 3, message="the name must be at least 3 characters")
    private String name;

    @ManyToMany(mappedBy = "categories")
    @JsonBackReference
    private List<Photo> photos;

    public Category() {}
    public Category(String name, Photo... photos) {
        setName(name);
        setPhotos(Arrays.asList(photos));
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public List<Photo> getPhotos() {
        return photos;
    }
    public void setPhotos(List<Photo> photos) {
        this.photos = photos;
    }
    public boolean hasPhoto(Photo photo) {
        if(getPhotos() == null) return false;

        for(Photo tempPhoto : getPhotos()) {
            if(tempPhoto.getId() == photo.getId()) return true;
        }

        return false;
    }
    public void addPhotos(Photo... photos) {
        getPhotos().addAll(Arrays.asList(photos));
    }
    public void removePhotos(Photo... photos) {
        getPhotos().removeAll(Arrays.asList(photos));
    }

    @Override
    public int hashCode() {
        return getId();
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Category)) return false;
        Category incomingCategory = (Category)obj;
        return getId() == incomingCategory.getId();
    }

    @Override
    public String toString() {
        return "[" + getId() + "] Caterories:\n"
                + "name: " + getName() + "\n"
                + "photo including the category: " + getPhotos();
    }
}