package com.tylerholzschuh.todoapp.services;

import com.tylerholzschuh.todoapp.entities.ToDoItem;
import com.tylerholzschuh.todoapp.repositories.ToDoItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

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

    @Transactional
    public void addToDoItemByUsername(String username, String item) {
        ToDoItem toDoItem = new ToDoItem(username, item);
        toDoItemRepository.addOrUpdateToDoItem(toDoItem);
    }

    @Transactional
    public void deleteToDoItemById(String username, long id) {
        toDoItemRepository.deleteToDoItemById(username, id);
    }

    @Transactional
    public void updateToDoItemById(String username, long id, String item) {
        Optional<ToDoItem> optionalToDoItem = toDoItemRepository.getToDoItemByID(username, id);

        if (optionalToDoItem.isPresent()) {
            ToDoItem toDoItem = optionalToDoItem.get();
            toDoItem.setItem(item);
            toDoItemRepository.addOrUpdateToDoItem(toDoItem);
        }
    }
}
