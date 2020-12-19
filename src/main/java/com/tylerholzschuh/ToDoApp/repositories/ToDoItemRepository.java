package com.tylerholzschuh.ToDoApp.repositories;

import com.tylerholzschuh.ToDoApp.entities.ToDoItem;
import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.List;

@Repository
public class ToDoItemRepository {

    private List<ToDoItem> toDoItems =
            Arrays.asList(new ToDoItem("Item 1"),
                          new ToDoItem("Item 2"),
                          new ToDoItem("Item 3"));

    public List<ToDoItem> getToDoItemsByUsername(String username) {
        return toDoItems;
    }

//    public void updateToDoItem(String username, int id) {
//
//    }
}
