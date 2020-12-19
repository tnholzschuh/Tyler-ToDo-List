package com.tylerholzschuh.todoapp.repositories;

import com.tylerholzschuh.todoapp.entities.ToDoItem;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Repository
public class ToDoItemRepository {

    private final SessionFactory sessionFactory;

//    private List<ToDoItem> toDoItems =
//            Arrays.asList(new ToDoItem(1, "tyler", "Item 1"),
//                          new ToDoItem(2, "tyler", "Item 2"),
//                          new ToDoItem(3, "tyler", "Item 3"));

    @Autowired
    public ToDoItemRepository(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }



    public List<ToDoItem> getToDoItemsByUsername(String username) {
        Session session = sessionFactory.getCurrentSession();

        Query<ToDoItem> query = session.createQuery("from ToDoItem where username=:username",
                ToDoItem.class);
        query.setParameter("username", username);

        @SuppressWarnings(value = "unchecked")
        List<ToDoItem> toDoItems = null;

        // System.out.println(query.getSingleResult().getItem());

        try {
            toDoItems = (List<ToDoItem>) query.getResultList();
        } catch (Exception e) {
            toDoItems = new ArrayList<ToDoItem>();
        }

        System.out.println(toDoItems.get(0));

        return toDoItems;
    }

//    public void updateToDoItem(String username, int id) {
//
//    }
}
