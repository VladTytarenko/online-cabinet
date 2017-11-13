package com.tytarenko.controller;

import com.tytarenko.entity.User;
import com.tytarenko.service.SecurityService;
import com.tytarenko.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/**
 * Controller for {@link User}'s pages/
 *
 * @author Vladyslav Tytarenko
 * @version 1.0
 */

@Controller
@RequestMapping("/")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private SecurityService securityService;

    @GetMapping("/hello")
    public String hello() {
        return "hello";
    }

    @GetMapping("/users+{id}")
    public String getAllUsers(@PathVariable("id") int id, Model model) {
        model.addAttribute("users", userService.findAll());
        return "usersList";
    }

    // @PathVariable - id який прийде в variable потрібно
    // використовувати для параметра id в методі
    @GetMapping("/user/{id}")
    public String getById(@PathVariable("id") int id, Model model) {
        model.addAttribute("user", userService.getById(id));
        return "showUser";
    }

    @GetMapping("/addUser")
    public String createUserPage() {
        return "createUser";
    }

    @PostMapping("/addUser")
    public String addUser(@ModelAttribute("user") User user) {
        try {
            userService.save(user);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "redirect:/users";
    }

    @GetMapping("/delete/{id}")
    public String deleteUser(@PathVariable("id") int id) {
        userService.delete(id);
        return "redirect:/users";
    }

    @GetMapping("/update/{id}")
    public String updateUser(@PathVariable("id") int id, Model model) {
        model.addAttribute("user", userService.getById(id));
        return "editUser";
    }

    @PostMapping("/updateUser")
    public String updateUser(@ModelAttribute User user) {
        userService.update(user);
        return "redirect:/user/" + user.getId() ;
    }

    @GetMapping("/login")
    public String login(Model model, String logout) {
        if (logout != null) {
            model.addAttribute("error", "Logged out successfully.");
        }
        return "login";
    }

    @GetMapping("/admin")
    public String admin(Model model) {
        return "admin";
    }

}