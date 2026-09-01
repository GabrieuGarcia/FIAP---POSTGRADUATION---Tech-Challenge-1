package com.fiap.techchallenge1restaurantsystem.adapter.out.persistence.mapper;

import com.fiap.techchallenge1restaurantsystem.adapter.out.persistence.UserJpaRepository;
import com.fiap.techchallenge1restaurantsystem.adapter.out.persistence.entities.UserEntity;
import com.fiap.techchallenge1restaurantsystem.application.port.out.UserRepositoryPort;
import com.fiap.techchallenge1restaurantsystem.domain.user.User;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Component
public class UserRepositoryAdapter implements UserRepositoryPort {

    private final UserJpaRepository userJpaRepository;

    public UserRepositoryAdapter(UserJpaRepository userJpaRepository) {
        this.userJpaRepository = userJpaRepository;
    }

    @Override
    public User save(User user) {
        UserEntity entity = userJpaRepository.findById(user.getId())
                .map(existing -> UserPersistenceMapper.updateEntity(existing, user))
                .orElseGet(() -> UserPersistenceMapper.toEntity(user));
        UserEntity saved = userJpaRepository.save(entity);
        return UserPersistenceMapper.toDomain(saved);
    }

    @Override
    public Optional<User> findById(UUID id) {
        return userJpaRepository.findById(id).map(UserPersistenceMapper::toDomain);
    }

    @Override
    public Optional<User> findByLogin(String login) {
        return userJpaRepository.findByLogin(login).map(UserPersistenceMapper::toDomain);
    }

    @Override
    public boolean existsByEmail(String email) {
        return userJpaRepository.existsByEmail(email);
    }

    @Override
    public boolean existsByLogin(String login) {
        return userJpaRepository.existsByLogin(login);
    }

    @Override
    public List<User> findByNameContainingIgnoreCase(String name) {
        return UserPersistenceMapper.toDomain(userJpaRepository.findByNameContainingIgnoreCase(name));
    }

    @Override
    public void deleteById(UUID id) {
        userJpaRepository.deleteById(id);
    }
}
