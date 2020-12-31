package com.tylerholzschuh.todoapp.services;

import com.tylerholzschuh.todoapp.entities.ToDoUser;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public interface ToDoUserDetailsService extends UserDetailsService {
    public void save(ToDoUser toDoUser);

    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException;
}
