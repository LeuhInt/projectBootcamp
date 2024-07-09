package me.leuhint.projectBootcamp.service.impl;

import me.leuhint.projectBootcamp.model.User;
import me.leuhint.projectBootcamp.repository.UserRepository;
import me.leuhint.projectBootcamp.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User findById(Long id) {
        return userRepository.findById(id).orElseThrow(NoSuchElementException::new);
    }

    @Override
    public User create(User user) {
        if (user.getId() != null && userRepository.existsById(user.getId())) {
            throw new IllegalArgumentException("User with id " + user.getId() + " already exists");
        }
        return userRepository.save(user);
    }

    @Override
    public User update(Long id, User userToUpdate) {
        User user = this.findById(id);
        if (!user.getId().equals(userToUpdate.getId())) {
            throw new IllegalArgumentException();
        }

        user.setName(userToUpdate.getName());
        user.setLevel(userToUpdate.getLevel());
        user.setAccount(userToUpdate.getAccount());
        user.setPokemon(userToUpdate.getPokemon());
        user.setProfession(userToUpdate.getProfession());
        user.setNews(userToUpdate.getNews());

        return this.userRepository.save(user);
    }

    @Override
    public void delete(Long id) {
        User userToDelete = this.findById(id);
        this.userRepository.delete(userToDelete);
    }

    @Override
    public List<User> findAll() {
        return this.userRepository.findAll();
    }
}
