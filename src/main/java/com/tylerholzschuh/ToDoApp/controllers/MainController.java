package com.tylerholzschuh.ToDoApp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    @GetMapping("/to-do-items")
    public String toDoItems() {
//        System.out.println(user);
        return "to-do-items";
    }

    @GetMapping("/")
    public String home() {
        return "redirect:/to-do-items";
    }
}
