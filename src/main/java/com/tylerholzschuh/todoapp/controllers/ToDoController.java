package com.tylerholzschuh.todoapp.controllers;

import com.tylerholzschuh.todoapp.services.ToDoItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ToDoController {

    private final ToDoItemService toDoItemService;

    @Autowired
    public ToDoController(ToDoItemService toDoItemService) {
        this.toDoItemService = toDoItemService;
    }



    @GetMapping("/todo-items")
    public String toDoItems(Authentication authentication, Model model) {
        model.addAttribute("toDoItems", toDoItemService.getToDoItemsByUsername(authentication.getName()));
        model.addAttribute("updateID", -1);
        return "todo-items";
    }

    @PostMapping("/add-todo-item")
    public String addToDoItem(@RequestParam("todo-item") String toDoItem, Authentication authentication) {
        toDoItemService.addToDoItemByUsername(authentication.getName(), toDoItem);
        return "redirect:/todo-items";
    }

    @PostMapping("/delete-todo-item/{id}")
    public String deleteToDoItem(@PathVariable("id") long id, Authentication authentication) {
        toDoItemService.deleteToDoItemById(authentication.getName(), id);
        return "redirect:/todo-items";
    }

    @PostMapping("/update-todo-item/{id}")
    public String updateToDoItem(@PathVariable("id") long id,
                                 @RequestParam("item") String item,
                                 Authentication authentication) {
        toDoItemService.updateToDoItemById(authentication.getName(), id, item);
        return "redirect:/todo-items";
    }

    @GetMapping("/show-update-todo-item/{id}")
    public String showUpdateToDoItem(@PathVariable("id") long id, Authentication authentication, Model model) {
        model.addAttribute("toDoItems", toDoItemService.getToDoItemsByUsername(authentication.getName()));
        model.addAttribute("updateID", id);
        return "todo-items";
    }


    @GetMapping("/")
    public String home() {
        if (isAuthenticated()) {
            return "redirect:/todo-items";
        } else {
            return "redirect:/login-page";
        }
    }

    private boolean isAuthenticated() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication == null || AnonymousAuthenticationToken.class.
                isAssignableFrom(authentication.getClass())) {
            return false;
        }
        return authentication.isAuthenticated();
    }
}
