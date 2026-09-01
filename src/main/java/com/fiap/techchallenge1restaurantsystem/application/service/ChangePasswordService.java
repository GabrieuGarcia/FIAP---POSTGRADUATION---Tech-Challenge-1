package com.fiap.techchallenge1restaurantsystem.application.service;

import com.fiap.techchallenge1restaurantsystem.application.port.in.ChangePasswordCommand;
import com.fiap.techchallenge1restaurantsystem.application.port.in.ChangePasswordUseCase;
import com.fiap.techchallenge1restaurantsystem.application.port.out.UserRepositoryPort;
import com.fiap.techchallenge1restaurantsystem.domain.user.User;
import com.fiap.techchallenge1restaurantsystem.domain.user.UserNotFoundException;
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
