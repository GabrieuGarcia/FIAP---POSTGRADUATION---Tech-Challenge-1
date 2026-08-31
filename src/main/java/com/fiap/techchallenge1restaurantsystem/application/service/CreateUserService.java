package com.fiap.techchallenge1restaurantsystem.application.service;

import com.fiap.techchallenge1restaurantsystem.application.port.in.CreateUserCommand;
import com.fiap.techchallenge1restaurantsystem.application.port.in.CreateUserUseCase;
import com.fiap.techchallenge1restaurantsystem.application.port.out.UserRepositoryPort;
import com.fiap.techchallenge1restaurantsystem.domain.user.User;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class CreateUserService implements CreateUserUseCase {

    private final UserRepositoryPort userRepositoryPort;

    public CreateUserService(UserRepositoryPort userRepositoryPort) {
        this.userRepositoryPort = userRepositoryPort;
    }

    @Override
    public User createUser(CreateUserCommand command) {
        User user = new User(
                UUID.randomUUID(),
                command.name(),
                command.email(),
                command.password(),
                command.address(),
                command.userType()
        );
        return userRepositoryPort.save(user);
    }
}
