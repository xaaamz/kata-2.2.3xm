package ru.kata312.kata312.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import ru.kata312.kata312.model.User;
import ru.kata312.kata312.services.UserService;


@Controller
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping()
    public String userList(ModelMap model) {
        model.addAttribute("users", userService.userAll());
        return "userList";
    }

    @GetMapping("/{id}")
    public String userById(@PathVariable("id") long id, Model model) {
        User user = userService.userById(id);
        if (user != null) {
            model.addAttribute("user", user);
            return "userById";
        } else {
            return "redirect:/user";
        }
    }
    @GetMapping("/hh")
    public String hh() {
        return "userById";
    }

    @GetMapping("/new")
    public String newUser(ModelMap model) {
        model.addAttribute("user", new User());
        return "userCreate";
    }

    @PostMapping()
    public String createUser(@ModelAttribute("user") User user) {
        userService.save(user);
        return "redirect:/user";
    }

    @GetMapping("/{id}/edit")
    public String editUser(@PathVariable("id") long id, ModelMap model) {
        User user = userService.userById(id);
        if (user != null) {
            model.addAttribute("user", user);
            return "userEdit";
        } else {
            return "redirect:/user";
        }
    }

    @PostMapping("/{id}/update")
    public String updateUser(@PathVariable("id") long id, @ModelAttribute("user") User user) {
        User user1 = userService.userById(id);
        userService.update(user);
        return "redirect:/user";
    }


    @DeleteMapping("/{id}/delete")
    public String deleteUser(@PathVariable("id") long id) {
        userService.delete(id);
        return "redirect:/user";
    }
}
