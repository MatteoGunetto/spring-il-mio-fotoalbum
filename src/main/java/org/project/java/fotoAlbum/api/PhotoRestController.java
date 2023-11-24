package org.project.java.fotoAlbum.api;

import java.util.List;
import java.util.Optional;

import org.project.java.fotoAlbum.api.dto.PhotoDto;
import org.project.java.fotoAlbum.db.foto.Photo;
import org.project.java.fotoAlbum.db.serv.PhotoService;





import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@RequestMapping("/api/v1/photos")
public class PhotoRestController {
    @Autowired
    private PhotoService photoService;

    @GetMapping
    public ResponseEntity<List<Photo>> fetchAllPhotos(){
        List<Photo> photos = photoService.findByVisibility();
        return new ResponseEntity<List<Photo>>(photos, HttpStatus.OK);
    }

    @GetMapping("/filter/{filter}")
    public ResponseEntity<List<Photo>> fetchFilteredPhotos(@PathVariable String filter){
        List<Photo> photos = photoService.findByTitle(filter);
        return new ResponseEntity<List<Photo>>(photos, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Integer> savePhoto(@RequestBody PhotoDto photoDto){
        Photo photo = new Photo(photoDto);
        photo = photoService.save(photo);

        return new ResponseEntity<>(photo.getId(), HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<Photo> fetchPhoto(@PathVariable int id){
        Optional<Photo> photoOpt = photoService.findById(id);

        if(photoOpt.isEmpty()) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }else {
            return new ResponseEntity<>(photoOpt.get(), HttpStatus.OK);
        }
    }

    @PutMapping("{id}")
    public ResponseEntity<Photo> updatePhoto(@PathVariable int id,
                                             @RequestBody PhotoDto photoDto){
        Optional<Photo> photoOpt = photoService.findById(id);

        if(photoOpt.isEmpty()) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }

        Photo photo = photoOpt.get();
        photo.fillFromPhotoDto(photoDto);

        try {
            photo = photoService.save(photo);
            return new ResponseEntity<>(photoOpt.get(), HttpStatus.OK);
        }catch(Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping
    public ResponseEntity<Boolean> deletePhoto(@PathVariable int id){
        Optional<Photo> photoOpt = photoService.findById(id);

        if(photoOpt.isEmpty()) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }

        Photo photo = photoOpt.get();
        photoService.deletePhoto(photo);

        return new ResponseEntity<>(true, HttpStatus.OK);
    }
}