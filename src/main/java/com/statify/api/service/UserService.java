package com.statify.api.service;

import com.statify.api.model.DAOUser;

import java.util.List;
import java.util.UUID;

public interface UserService {
    DAOUser create(DAOUser user);
    List<DAOUser> read();
    DAOUser getByUsername(String username);
    DAOUser update(UUID id, DAOUser user);
    String delete(UUID id);
}
