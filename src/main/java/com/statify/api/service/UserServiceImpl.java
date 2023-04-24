package com.statify.api.service;


import com.statify.api.model.DAOUser;
import com.statify.api.repository.UserDAO;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserDAO userRepository;
    @Override
    public DAOUser create(DAOUser user) {
        return userRepository.save(user);
    }

    @Override
    public List<DAOUser> read() {
        return userRepository.findAll();
    }

    @Override
    public DAOUser getByUsername(String username) {
        List<DAOUser> users = userRepository.findAll();
        for(DAOUser u : users) {
            if (u.getUsername().equals(username))
                return u;
        }
        return null;
    }

    @Override
    public DAOUser update(UUID id, DAOUser user) {
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
