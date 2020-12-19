package com.tylerholzschuh.ToDoApp.entities;

public class ToDoItem {

    String item;

    public ToDoItem() {
    }

    public ToDoItem(String item) {
        this.item = item;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }
}
