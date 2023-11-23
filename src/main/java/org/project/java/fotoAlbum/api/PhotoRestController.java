package org.project.java.fotoAlbum.api;

import java.util.List;

import org.project.java.fotoAlbum.api.dto.PhotoDto;
import org.project.java.fotoAlbum.db.foto.Photo;
import org.project.java.fotoAlbum.db.repo.PhotoRepo;
import org.project.java.fotoAlbum.db.serv.PhotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@RequestMapping("/api/v1")
public class PhotoRestController {

    @Autowired
    private PhotoService photoService;

    @GetMapping
    public ResponseEntity<List<Photo>> fetchAllPhotos() {
        List<Photo> photos = photoService.findAll();
        return new ResponseEntity<>(photos, HttpStatus.OK);
    }

    @GetMapping("/filtered/{filter}")
    public ResponseEntity<List<Photo>> fetchFilteredPhotos(@PathVariable String filter) {
        List<Photo> photos = photoService.findByTitle(filter);
        return new ResponseEntity<>(photos, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Integer> savePhoto(@RequestBody PhotoDto photoDto) {
        Photo photo = new Photo(photoDto);
        photo = photoService.save(photo);
        return new ResponseEntity<>(photo.getId(), HttpStatus.OK);
    }
}
