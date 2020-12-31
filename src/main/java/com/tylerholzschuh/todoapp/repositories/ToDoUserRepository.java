package com.tylerholzschuh.todoapp.repositories;

import com.tylerholzschuh.todoapp.entities.ToDoUser;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import org.hibernate.query.Query;

import java.util.Optional;

@Repository
public class ToDoUserRepository {

    @Autowired
    private SessionFactory sessionFactory;

    public Optional<ToDoUser> findByUsername(String username) {
        Session session = sessionFactory.getCurrentSession();

        Query<ToDoUser> query = session.createQuery("from ToDoUser where username=:username", ToDoUser.class);
        query.setParameter("username", username);

        System.out.println(username);

        return query.uniqueResultOptional();
    }

    public void save(ToDoUser toDoUser) {
        Session session = sessionFactory.getCurrentSession();

        session.saveOrUpdate(toDoUser);
    }
}
