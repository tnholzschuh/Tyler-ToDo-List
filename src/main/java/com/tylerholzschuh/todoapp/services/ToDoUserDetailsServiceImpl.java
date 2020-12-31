package com.tylerholzschuh.todoapp.services;

import com.tylerholzschuh.todoapp.entities.ToDoUser;
import com.tylerholzschuh.todoapp.repositories.ToDoUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class ToDoUserDetailsServiceImpl implements ToDoUserDetailsService {

    @Autowired
    private ToDoUserRepository toDoUserRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Transactional
    public void save(ToDoUser toDoUser) {
        toDoUser.setPassword(passwordEncoder.encode(toDoUser.getPassword()));
        toDoUserRepository.save(toDoUser);
    }

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        System.out.println("loadUser Service: " + username);
        System.out.println("Repository: " + toDoUserRepository);
        Optional<ToDoUser> optionalUser = toDoUserRepository.findByUsername(username);

        if (optionalUser.isEmpty()) {
            throw new UsernameNotFoundException("Invalid username or password.");
        }

        ToDoUser toDoUser = optionalUser.get();

        return new org.springframework.security.core.userdetails.User(
                toDoUser.getUsername(),
                toDoUser.getPassword(),
                List.of(new SimpleGrantedAuthority("USER")));
    }
}
