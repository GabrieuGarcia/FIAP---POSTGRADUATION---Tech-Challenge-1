package com.fiap.techchallenge1restaurantsystem.adapter.out.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface UserJpaRepository extends JpaRepository<UserEntity, UUID> {

    Optional<UserEntity> findByLogin(String login);

    boolean existsByEmail(String email);

    boolean existsByLogin(String login);

    List<UserEntity> findByNameContainingIgnoreCase(String name);
}
