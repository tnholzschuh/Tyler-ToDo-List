package com.tylerholzschuh.todoapp.controllers;

import com.tylerholzschuh.todoapp.entities.ToDoUser;
import com.tylerholzschuh.todoapp.services.ToDoUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ToDoSecurityController {

    private final ToDoUserDetailsService toDoUserDetailsService;

    @Autowired
    public ToDoSecurityController(ToDoUserDetailsService toDoUserDetailsService) {
        this.toDoUserDetailsService = toDoUserDetailsService;
    }

    @GetMapping("/login-page")
    public String loginPage(Model model) {
        model.addAttribute("toDoUser", new ToDoUser());
        return "login";
    }

    @GetMapping("/register-form")
    public String registerForm(Model model) {
        model.addAttribute("success", "Not Tried");
        model.addAttribute("toDoUser", new ToDoUser());
        System.out.println("Called registerForm");
        return "register-form";
    }

    @PostMapping("/register")
    public String register(@ModelAttribute("toDoUser") ToDoUser toDoUser, Model model) {
        System.out.println("register line 38: " + toDoUser);
        try {
            toDoUserDetailsService.loadUserByUsername(toDoUser.getUsername());
            model.addAttribute("success", "Failed");
            model.addAttribute("user", new ToDoUser());
            return "register-form";
        } catch (UsernameNotFoundException e){
            System.out.println(toDoUser.getUsername());
            toDoUserDetailsService.save(toDoUser);
            return "redirect:/login-page";
        }
    }
}
