package com.statify.api.service;


import com.statify.api.model.User;
import com.statify.api.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.UUID;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    @Override
    public User create(User user) {
        return userRepository.save(user);
    }

    @Override
    public List<User> read() {
        return userRepository.findAll();
    }

    @Override
    public User getByUsername(String username) {
        List<User> users = userRepository.findAll();
        for(User u : users) {
            if (u.getUsername().equals(username))
                return u;
        }
        return null;
    }

    @Override
    public User update(UUID id, User user) {
        return userRepository.findById(id)
                .map(u -> {
                    u.setUsername(user.getUsername() != null ? user.getUsername() : u.getUsername());
                    u.setPassword(user.getPassword() != null ? user.getPassword() : u.getPassword());
                    return userRepository.save(u);
                }).orElseThrow(() -> new RuntimeException("Utilisateur non trouvé"));
    }

    @Override
    public String delete(UUID id) {
        userRepository.deleteById(id);
        return "Utilisateur supprimé";
    }
}
