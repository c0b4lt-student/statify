package com.statify.api.service;

import com.statify.api.model.User;

import java.util.List;
import java.util.UUID;

public interface UserService {
    User create(User user);
    List<User> read();
    User getByUsername(String username);
    User update(UUID id, User user);
    String delete(UUID id);
}
