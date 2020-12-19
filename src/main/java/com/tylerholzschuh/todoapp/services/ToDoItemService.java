package com.tylerholzschuh.todoapp.services;

import com.tylerholzschuh.todoapp.entities.ToDoItem;
import com.tylerholzschuh.todoapp.repositories.ToDoItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ToDoItemService {

    private final ToDoItemRepository toDoItemRepository;

    @Autowired
    public ToDoItemService(ToDoItemRepository toDoItemRepository) {
        this.toDoItemRepository = toDoItemRepository;
    }

    @Transactional
    public List<ToDoItem> getToDoItemsByUsername(String username) {
        return toDoItemRepository.getToDoItemsByUsername(username);
    }

}
