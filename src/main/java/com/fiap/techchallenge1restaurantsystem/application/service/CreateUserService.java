package com.fiap.techchallenge1restaurantsystem.application.service;

import com.fiap.techchallenge1restaurantsystem.application.port.in.CreateUserCommand;
import com.fiap.techchallenge1restaurantsystem.application.port.in.CreateUserUseCase;
import com.fiap.techchallenge1restaurantsystem.application.port.out.UserRepositoryPort;
import com.fiap.techchallenge1restaurantsystem.domain.user.EmailAlreadyInUseException;
import com.fiap.techchallenge1restaurantsystem.domain.user.LoginAlreadyInUseException;
import com.fiap.techchallenge1restaurantsystem.domain.user.User;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.UUID;

@Service
public class CreateUserService implements CreateUserUseCase {

    private final UserRepositoryPort userRepositoryPort;

    public CreateUserService(UserRepositoryPort userRepositoryPort) {
        this.userRepositoryPort = userRepositoryPort;
    }

    @Override
    public User createUser(CreateUserCommand command) {
        if (userRepositoryPort.existsByEmail(command.email().getValue())) {
            throw new EmailAlreadyInUseException(command.email().getValue());
        }
        if (userRepositoryPort.existsByLogin(command.login())) {
            throw new LoginAlreadyInUseException(command.login());
        }

        User user = new User(
                UUID.randomUUID(),
                command.name(),
                command.email(),
                command.login(),
                command.password(),
                command.address(),
                command.userType(),
                new Date()
        );
        return userRepositoryPort.save(user);
    }
}
