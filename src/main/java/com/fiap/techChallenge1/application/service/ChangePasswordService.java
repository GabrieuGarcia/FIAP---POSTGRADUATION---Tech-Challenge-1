package com.fiap.techChallenge1.application.service;

import com.fiap.techChallenge1.application.port.in.command.ChangePasswordCommand;
import com.fiap.techChallenge1.application.port.in.usecases.ChangePasswordUseCase;
import com.fiap.techChallenge1.application.port.out.UserRepositoryPort;
import com.fiap.techChallenge1.domain.user.User;
import com.fiap.techChallenge1.domain.user.UserNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class ChangePasswordService implements ChangePasswordUseCase {

    private final UserRepositoryPort userRepositoryPort;

    public ChangePasswordService(UserRepositoryPort userRepositoryPort) {
        this.userRepositoryPort = userRepositoryPort;
    }

    @Override
    public void changePassword(ChangePasswordCommand command) {
        User user = userRepositoryPort.findById(command.userId())
                .orElseThrow(() -> new UserNotFoundException(command.userId()));

        user.changePassword(command.currentPassword(), command.newPassword());
        userRepositoryPort.save(user);
    }
}
