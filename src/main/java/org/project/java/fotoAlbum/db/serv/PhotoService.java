package org.project.java.fotoAlbum.db.serv;

import java.util.List;
import java.util.Optional;

import org.project.java.fotoAlbum.db.foto.Photo;
import org.project.java.fotoAlbum.db.foto.User;
import org.project.java.fotoAlbum.db.repo.PhotoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PhotoService {

    @Autowired
    private PhotoRepo photoRepo;

    public List<Photo> findAll(){
        return photoRepo.findAll();
    }

    public Optional<Photo> findById(int id){
        return photoRepo.findById(id);
    }

    public List<Photo> findByVisibility(){
        return photoRepo.findByVisible(true);
    }

    public List<Photo> findByTitle(String title){
        return photoRepo.findByTitle(title);
    }

    public List<Photo> findByUserAndTitle(User user, String title){
        return photoRepo.findByUserAndTitleContaining(user, title);
    }

    public List<Photo> findByUser(User user){
        return photoRepo.findByUser(user);
    }

    public Photo save(Photo photo) {
        return photoRepo.save(photo);
    }

    public void deletePhoto(Photo photo) {
        photoRepo.delete(photo);
    }
}