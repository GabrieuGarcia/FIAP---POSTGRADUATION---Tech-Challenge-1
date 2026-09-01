package com.fiap.techChallenge1.application.service;

import com.fiap.techChallenge1.application.port.in.command.LoginCommand;
import com.fiap.techChallenge1.application.port.in.usecases.LoginUserUseCase;
import com.fiap.techChallenge1.application.port.out.UserRepositoryPort;
import com.fiap.techChallenge1.domain.user.InvalidCredentialsException;
import com.fiap.techChallenge1.domain.user.PasswordEncoderPort;
import com.fiap.techChallenge1.domain.user.User;
import org.springframework.stereotype.Service;

@Service
public class LoginUserService implements LoginUserUseCase {

    private static final String INVALID_CREDENTIALS_MESSAGE = "Invalid login or password";

    private final UserRepositoryPort userRepositoryPort;
    private final PasswordEncoderPort passwordEncoderPort;

    public LoginUserService(UserRepositoryPort userRepositoryPort, PasswordEncoderPort passwordEncoderPort) {
        this.userRepositoryPort = userRepositoryPort;
        this.passwordEncoderPort = passwordEncoderPort;
    }

    @Override
    public User login(LoginCommand command) {
        User user = userRepositoryPort.findByLogin(command.login())
                .orElseThrow(() -> new InvalidCredentialsException(INVALID_CREDENTIALS_MESSAGE));

        if (!user.authenticate(command.password(), passwordEncoderPort)) {
            throw new InvalidCredentialsException(INVALID_CREDENTIALS_MESSAGE);
        }

        return user;
    }
}
