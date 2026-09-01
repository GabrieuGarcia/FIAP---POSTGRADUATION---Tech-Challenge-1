package com.fiap.techchallenge1restaurantsystem.application.service;

import com.fiap.techchallenge1restaurantsystem.application.port.in.command.LoginCommand;
import com.fiap.techchallenge1restaurantsystem.application.port.in.usecases.LoginUserUseCase;
import com.fiap.techchallenge1restaurantsystem.application.port.out.UserRepositoryPort;
import com.fiap.techchallenge1restaurantsystem.domain.user.InvalidCredentialsException;
import com.fiap.techchallenge1restaurantsystem.domain.user.User;
import org.springframework.stereotype.Service;

@Service
public class LoginUserService implements LoginUserUseCase {

    private static final String INVALID_CREDENTIALS_MESSAGE = "Invalid login or password";

    private final UserRepositoryPort userRepositoryPort;

    public LoginUserService(UserRepositoryPort userRepositoryPort) {
        this.userRepositoryPort = userRepositoryPort;
    }

    @Override
    public User login(LoginCommand command) {
        User user = userRepositoryPort.findByLogin(command.login())
                .orElseThrow(() -> new InvalidCredentialsException(INVALID_CREDENTIALS_MESSAGE));

        if (!user.authenticate(command.password())) {
            throw new InvalidCredentialsException(INVALID_CREDENTIALS_MESSAGE);
        }

        return user;
    }
}
