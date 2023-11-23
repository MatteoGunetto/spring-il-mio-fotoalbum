package org.project.java.fotoAlbum.controller;

import java.util.List;
import java.util.Optional;

import org.project.java.fotoAlbum.db.foto.Category;
import org.project.java.fotoAlbum.db.foto.Photo;
import org.project.java.fotoAlbum.db.serv.CategoryService;
import org.project.java.fotoAlbum.db.serv.PhotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/photos")
public class PhotoController {
    @Autowired
    private PhotoService photoService;

    @Autowired
    private CategoryService categoryService;

    @GetMapping
    public String photos__index(Model model,
                                @RequestParam(required = false) String title) {
        List<Photo> photos = title == null
                ? photoService.findAll()
                : photoService.findByTitle(title);

        model.addAttribute("photos", photos);

        return "photos/photos_index";
    }

    @GetMapping("/{photo_id}")
    public String photos__show(Model model,
                               @PathVariable int id) {
        Optional<Photo> photoOpt = photoService.findById(id);
        if(!photoOpt.isEmpty()) {
            Photo photo = photoOpt.get();

            model.addAttribute("photo", photo);

            return "photos/photo_show";
        }
        return "not_found";
    }

    @GetMapping("/create")
    public String photos__create(Model model) {
        Photo photo = new Photo();
        List<Category> categoriesList = categoryService.findAll();

        model.addAttribute("photo", photo);
        model.addAttribute("categoriesList", categoriesList);

        return "photos/photos_form";
    }

    @PostMapping("/create")
    public String photos__store(Model model,
                                @Valid @ModelAttribute Photo photo,
                                BindingResult bindingResult) {
        if(bindingResult.hasErrors()) {
            System.err.println("Error: ");
            bindingResult.getAllErrors().forEach(System.err::println);
            return "photos/photos_form";
        }else {
            try {
                photoService.save(photo);
            }catch(Exception e) {
                System.err.println(e.getMessage());
                return "photos/photos_form";
            }
        }
        return "redirect:/photos";
    }

    @GetMapping("/update/{photo_id}")
    public String photos__edit(Model model,
                               @PathVariable("photo_id") int id) {
        Optional<Photo> photoOpt = photoService.findById(id);
        if(!photoOpt.isEmpty()) {
            Photo photo = photoOpt.get();
            List<Category> categoriesList = categoryService.findAll();

            model.addAttribute("categoriesList", categoriesList);
            model.addAttribute("photo", photo);

            return "photos/photos_form";
        }

        return "not_found";
    }

    @PostMapping("/update/{photo_id}")
    public String photos__update(@Valid @ModelAttribute Photo photo,
                                 BindingResult bindingResult,
                                 Model model,
                                 @PathVariable("photo_id") int id) {
        if(bindingResult.hasErrors()) {
            System.err.println("Error: ");
            bindingResult.getAllErrors().forEach(System.err::println);
            return "photos/photos_form";
        }else {
            try {
                photo.setId(id);
                photoService.save(photo);
            }catch(Exception e) {
                System.err.println(e.getMessage());
                return "photos/photos_form";
            }
        }
        return "redirect:/photos";
    }

    @PostMapping("/delete/{photo_id}")
    public String photos__delete(Model model,
                                 @PathVariable("photo_id") int id) {
        Optional<Photo> photoOpt = photoService.findById(id);
        if(!photoOpt.isEmpty()) {
            Photo photo = photoOpt.get();
            photoService.deletePhoto(photo);
            return "redirect:/photos";
        }
        return "not_found";
    }
}
