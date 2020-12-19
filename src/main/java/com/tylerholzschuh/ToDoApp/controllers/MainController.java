package com.tylerholzschuh.ToDoApp.controllers;

import com.tylerholzschuh.ToDoApp.services.ToDoItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    private final ToDoItemService toDoItemService;

    @Autowired
    public MainController(ToDoItemService toDoItemService) {
        this.toDoItemService = toDoItemService;
    }

    @GetMapping("/to-do-items")
    public String toDoItems(Model model) {
        model.addAttribute("toDoItems", toDoItemService.getToDoItemsByUsername("hello"));
        return "to-do-items";
    }

    @GetMapping("/")
    public String home() {
        return "redirect:/to-do-items";
    }
}
