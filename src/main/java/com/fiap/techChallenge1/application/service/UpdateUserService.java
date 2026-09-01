package com.fiap.techChallenge1.application.service;

import com.fiap.techChallenge1.application.port.in.command.UpdateUserCommand;
import com.fiap.techChallenge1.application.port.in.usecases.UpdateUserUseCase;
import com.fiap.techChallenge1.application.port.out.UserRepositoryPort;
import com.fiap.techChallenge1.domain.user.EmailAlreadyInUseException;
import com.fiap.techChallenge1.domain.user.LoginAlreadyInUseException;
import com.fiap.techChallenge1.domain.user.User;
import com.fiap.techChallenge1.domain.user.UserNotFoundException;
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
