package com.tylerholzschuh.todoapp.entities;

import javax.persistence.*;

@Entity
@Table(name = "todo_item")
public class ToDoItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "username")
    private String username;

    @Column(name = "todo_item")
    String item;


    public ToDoItem() {
    }

    public ToDoItem(long id, String username, String item) {
        this.id = id;
        this.item = item;
        this.username = username;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }


}
