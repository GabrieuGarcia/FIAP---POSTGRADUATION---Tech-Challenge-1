package com.fiap.techChallenge1.application.service;

import com.fiap.techChallenge1.application.port.in.command.ChangePasswordCommand;
import com.fiap.techChallenge1.application.port.in.usecases.ChangePasswordUseCase;
import com.fiap.techChallenge1.application.port.out.UserRepositoryPort;
import com.fiap.techChallenge1.domain.user.PasswordEncoderPort;
import com.fiap.techChallenge1.domain.user.User;
import com.fiap.techChallenge1.domain.user.UserNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class ChangePasswordService implements ChangePasswordUseCase {

    private final UserRepositoryPort userRepositoryPort;
    private final PasswordEncoderPort passwordEncoderPort;

    public ChangePasswordService(UserRepositoryPort userRepositoryPort, PasswordEncoderPort passwordEncoderPort) {
        this.userRepositoryPort = userRepositoryPort;
        this.passwordEncoderPort = passwordEncoderPort;
    }

    @Override
    public void changePassword(ChangePasswordCommand command) {
        User user = userRepositoryPort.findById(command.userId())
                .orElseThrow(() -> new UserNotFoundException(command.userId()));

        user.changePassword(command.currentPassword(), command.newPassword(), passwordEncoderPort);
        userRepositoryPort.save(user);
    }
}
