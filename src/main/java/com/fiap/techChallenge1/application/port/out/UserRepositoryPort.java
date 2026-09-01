package com.fiap.techChallenge1.application.port.out;

import com.fiap.techChallenge1.domain.user.User;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface UserRepositoryPort {

    User save(User user);

    Optional<User> findById(UUID id);

    Optional<User> findByLogin(String login);

    boolean existsByEmail(String email);

    boolean existsByLogin(String login);

    List<User> findByNameContainingIgnoreCase(String name);

    void deleteById(UUID id);
}
