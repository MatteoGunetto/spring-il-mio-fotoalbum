package org.project.java.fotoAlbum.controller;

import org.project.java.fotoAlbum.db.foto.Photo;
import org.project.java.fotoAlbum.db.serv.PhotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;

import java.util.List;
import java.util.Optional;

@Controller("/photos")
public class PhotoController {
    @Autowired
    private PhotoService photoService;

    @GetMapping
    public String photos_index(Model model,
                               @RequestParam(required = false) String title) {
        List<Photo> photos = title == null
                ? photoService.findAll()
                : photoService.findByTitle(title);

        model.addAttribute("photos", photos);

        return "photos/photos_index";
    }

    @GetMapping("/{photo_id}")
    public String photos_show(Model model,
                              @PathVariable int photo_id) {
        Optional<Photo> photoOpt = photoService.findById(photo_id);
        if (photoOpt.isPresent()) {
            Photo photo = photoOpt.get();
            model.addAttribute("photo", photo);
            return "photos_show";
        }
        return "not_found";
    }

    @GetMapping("/create")
    public String photos_create(Model model) {
        Photo photo = new Photo();
        model.addAttribute("photo", photo);
        return "photos_form";
    }

    @PostMapping("/create")
    public String photos_store(Model model,
                               @Valid @ModelAttribute Photo photo,
                               BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            System.err.println("Error: ");
            bindingResult.getAllErrors().forEach(System.err::println);
            return "photos_form";
        } else {
            try {
                photoService.save(photo);
            } catch (Exception e) {
                System.err.println(e.getMessage());
                return "photos_form";
            }
        }
        return "redirect:/photos";
    }

    @GetMapping("/update/{photo_id}")
    public String photos_edit(Model model,
                              @PathVariable("photo_id") int photo_id) {
        Optional<Photo> photoOpt = photoService.findById(photo_id);
        if (photoOpt.isPresent()) {
            Photo photo = photoOpt.get();
            model.addAttribute("photo", photo);
            return "photos_form";
        }
        return "not_found";
    }

    @PostMapping("/update/{photo_id}")
    public String photos_update(Model model,
                                @Valid @ModelAttribute Photo photo,
                                BindingResult bindingResult,
                                @PathVariable("photo_id") int photo_id) {
        if (bindingResult.hasErrors()) {
            System.err.println("Error: ");
            bindingResult.getAllErrors().forEach(System.err::println);
            return "photos_form";
        } else {
            try {
                photoService.save(photo);
            } catch (Exception e) {
                System.err.println(e.getMessage());
                return "photos_form";
            }
        }
        return "redirect:/photos";
    }

    @PostMapping("/delete/{photo_id}")
    public String photos_delete(Model model,
                                @PathVariable("photo_id") int photo_id) {
        Optional<Photo> photoOpt = photoService.findById(photo_id);
        if (photoOpt.isPresent()) {
            Photo photo = photoOpt.get();
            photoService.deletePhoto(photo);
            return "redirect:/photos";
        }
        return "not_found";
    }
}

