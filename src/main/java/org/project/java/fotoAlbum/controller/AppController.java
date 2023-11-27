package org.project.java.fotoAlbum.controller;

import java.util.Arrays;
import java.util.HashSet;

import org.project.java.fotoAlbum.api.dto.UserDto;
import org.project.java.fotoAlbum.db.foto.User;
import org.project.java.fotoAlbum.db.serv.RoleService;
import org.project.java.fotoAlbum.db.serv.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.WebRequest;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;

@Controller
@RequestMapping("/")
public class AppController {

    @Autowired
    private UserService userService;

    @Autowired
    private RoleService roleService;

    @GetMapping
    public String index() {
        return "index";
    }

    @GetMapping("/user/register")
    public String showRegistrationForm(WebRequest request, Model model) {
        UserDto uderDto = new UserDto();

        model.addAttribute("user", uderDto);

        return "register";
    }

    @PostMapping("/user/register")
    public String registerUser(@ModelAttribute("user") @Valid UserDto userDto, HttpServletRequest request, Errors errors) {
        try {
            User registered = new User(userDto);
            registered.setRoles(new HashSet<>(Arrays.asList(roleService.findById(1))));
            registered.setPassword(new BCryptPasswordEncoder().encode(userDto.getPassword()));			userService.save(registered);
        }catch(Exception e) {
            System.err.println(e.getMessage());
        }
        return "redirect:/login";
    }
}