package com.statify.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.statify.api.model.DAOUser;

import java.util.UUID;

@Repository
public interface UserDAO extends JpaRepository<DAOUser, UUID> {
    DAOUser findByUsername(String username);
}
