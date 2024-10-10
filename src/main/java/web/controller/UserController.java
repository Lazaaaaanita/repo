package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import web.model.User;
import web.service.UserService;

import java.util.ArrayList;
import java.util.List;

@Controller
public class UserController {

    private final UserService userService;
    @Autowired
    public UserController(UserService userService){ this.userService=userService;}

    @GetMapping(value = "/users")
    public String usersPage(ModelMap model) {
        model.addAttribute("users", userService.getAllUsers());
        return "users";
    }
    @GetMapping("/users/add")
    public String addPage(ModelMap model){
        model.addAttribute("user", new User());
        return "add";
    }
    @PostMapping("/users/add")
    public String addUser(@ModelAttribute User user){
        userService.save(user);
        return "redirect:/users";
    }

    @GetMapping("/users/edit")
    public String editPage(@RequestParam(value="id") long id, ModelMap model){
        model.addAttribute("user",userService.getUserById(id));
                return "edit";
    }
    @PostMapping("/users/edit")
    public String editUser(@ModelAttribute User user){
        userService.update(user);
        return "redirect:/users";
    }

    @GetMapping("/users/delete")
    public String deleteCustomerForm(@RequestParam long id) {
        userService.remove(id);
        return "redirect:/users";
    }

}