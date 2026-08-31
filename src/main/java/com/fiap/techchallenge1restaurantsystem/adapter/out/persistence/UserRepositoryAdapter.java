package com.fiap.techchallenge1restaurantsystem.adapter.out.persistence;

import com.fiap.techchallenge1restaurantsystem.application.port.out.UserRepositoryPort;
import com.fiap.techchallenge1restaurantsystem.domain.user.User;
import org.springframework.stereotype.Component;

@Component
public class UserRepositoryAdapter implements UserRepositoryPort {

    private final UserJpaRepository userJpaRepository;

    public UserRepositoryAdapter(UserJpaRepository userJpaRepository) {
        this.userJpaRepository = userJpaRepository;
    }

    @Override
    public User save(User user) {
        UserEntity saved = userJpaRepository.save(UserPersistenceMapper.toEntity(user));
        return UserPersistenceMapper.toDomain(saved);
    }
}
