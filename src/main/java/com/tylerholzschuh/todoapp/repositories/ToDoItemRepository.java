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
import java.util.Optional;

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

    public Optional<ToDoItem> getToDoItemByID(String username, long id) {
        Session session = sessionFactory.getCurrentSession();

        Query<ToDoItem> query = session.createQuery("from ToDoItem where username=:username AND id=:id",
                ToDoItem.class);
        query.setParameter("username", username);
        query.setParameter("id", id);

        Optional<ToDoItem> toDoItem;

        toDoItem = Optional.ofNullable(query.getSingleResult());

        return toDoItem;
    }

    public List<ToDoItem> getToDoItemsByUsername(String username) {
        Session session = sessionFactory.getCurrentSession();

        Query<ToDoItem> query = session.createQuery("from ToDoItem where username=:username",
                ToDoItem.class);
        query.setParameter("username", username);

        List<ToDoItem> toDoItems = null;

        try {
            toDoItems = query.getResultList();
        } catch (Exception e) {
            toDoItems = new ArrayList<ToDoItem>();
        }

        return toDoItems;
    }

    public void addOrUpdateToDoItem(ToDoItem toDoItem) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(toDoItem);
    }

    public void deleteToDoItemById(String username, long id) {
        Session session = sessionFactory.getCurrentSession();
        String hql = "delete from ToDoItem where id=:id AND username=:username";
        Query query = session.createQuery(hql);
        query.setParameter("username", username);
        query.setParameter("id", id);
        query.executeUpdate();
    }

//    public void updateToDoItem(String username, int id) {
//
//    }
}
