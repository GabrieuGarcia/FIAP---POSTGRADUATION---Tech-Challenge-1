package com.fiap.techchallenge1restaurantsystem.application.service;

import com.fiap.techchallenge1restaurantsystem.application.port.in.UpdateUserCommand;
import com.fiap.techchallenge1restaurantsystem.application.port.in.UpdateUserUseCase;
import com.fiap.techchallenge1restaurantsystem.application.port.out.UserRepositoryPort;
import com.fiap.techchallenge1restaurantsystem.domain.user.EmailAlreadyInUseException;
import com.fiap.techchallenge1restaurantsystem.domain.user.LoginAlreadyInUseException;
import com.fiap.techchallenge1restaurantsystem.domain.user.User;
import com.fiap.techchallenge1restaurantsystem.domain.user.UserNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UpdateUserService implements UpdateUserUseCase {

    private final UserRepositoryPort userRepositoryPort;

    public UpdateUserService(UserRepositoryPort userRepositoryPort) {
        this.userRepositoryPort = userRepositoryPort;
    }

    @Override
    public User updateUser(UpdateUserCommand command) {
        User user = userRepositoryPort.findById(command.userId())
                .orElseThrow(() -> new UserNotFoundException(command.userId()));

        if (!user.getEmail().getValue().equals(command.email().getValue())
                && userRepositoryPort.existsByEmail(command.email().getValue())) {
            throw new EmailAlreadyInUseException(command.email().getValue());
        }
        if (!user.getLogin().equals(command.login())
                && userRepositoryPort.existsByLogin(command.login())) {
            throw new LoginAlreadyInUseException(command.login());
        }

        user.updateInfo(command.name(), command.email(), command.login(), command.address());
        return userRepositoryPort.save(user);
    }
}
