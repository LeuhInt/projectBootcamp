package me.leuhint.projectBootcamp.service;

import me.leuhint.projectBootcamp.model.User;

import java.util.List;

public interface UserService {

    User findById(Long id);

    User create(User user);

    public User update(Long id, User userToUpdate);

    void delete(Long id);

    List<User> findAll();
}
