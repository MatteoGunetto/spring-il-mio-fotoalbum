package org.project.java.fotoAlbum.db.repo;

import java.util.List;

import org.project.java.fotoAlbum.db.foto.Photo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PhotoRepo extends JpaRepository<Photo, Integer>{
    public List<Photo> findByTitle(String title);
    public List<Photo> findByTitleContaining(String title);
    public List<Photo> findByTitleOrDescriptionContaining(String title, String description);
}