package com.tylerholzschuh.ToDoApp.services;

import com.tylerholzschuh.ToDoApp.entities.ToDoItem;
import com.tylerholzschuh.ToDoApp.repositories.ToDoItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ToDoItemService {

    private final ToDoItemRepository toDoItemRepository;

    @Autowired
    public ToDoItemService(ToDoItemRepository toDoItemRepository) {
        this.toDoItemRepository = toDoItemRepository;
    }

    public List<ToDoItem> getToDoItemsByUsername(String username) {
        return toDoItemRepository.getToDoItemsByUsername(username);
    }

}
